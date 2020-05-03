package com.example.projectsatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private var namaInput : String = ""
private var emailInput : String = ""
private var telpInput : String = ""
private var alamatInput : String = ""
private var genderInput : String = ""

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()
        btnSave.setOnClickListener { validasiInput() }

    }

    private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }

    private fun validasiInput(){
        namaInput = editName.text.toString()
        emailInput = editEmail.text.toString()
        telpInput = editTelp.text.toString()
        alamatInput = editAddress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()

        when{
            namaInput.isEmpty() -> editName.error = "Nama tidak boleh kosong"
            genderInput.equals("Jenis Kelamin harus dipilih", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih")
            emailInput.isEmpty() -> editEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> editTelp.error = "Telepon tidak boleh kosong"
            alamatInput.isEmpty() -> editAddress.error = "Alamat tidak boleh kosong"

            else-> {
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
