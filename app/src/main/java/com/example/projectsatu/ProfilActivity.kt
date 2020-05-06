package com.example.projectsatu

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*
import android.content.Intent
import android.net.Uri

import android.widget.Toast


class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()
        btnEditName.setOnClickListener { navigasiKeEditProfil() }
        btnTelepon.setOnClickListener { dialPhoneNumber(txtTelp.text.toString()) }
        btnAbout.setOnClickListener { navigasiKeAbout()  }

    }

    private fun ambilData(){
        val bundle = intent.extras

        val nama = bundle!!.getString("nama")
        val gender = bundle.getString("gender")
        val umur = bundle.getString("umur")
        val email = bundle.getString("email")
        val telp = bundle.getString("telp")
        val alamat = bundle.getString("alamat")

        txtname.text = nama
        jk.text = gender
        txtUmur.text = umur
        txtEmail.text = email
        txtTelp.text = telp
        txtAddress.text = alamat
    }

    companion object {
        val REQUEST_CODE = 100
    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActivity::class.java)
        val namaUser = txtname.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }

    private fun navigasiKeAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        val namaUser = txtname.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtname.text = result
            }else{
                Toast.makeText(this, "Edit failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}
