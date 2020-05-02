<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    xmlns:card_view="http://schemas.android.com/apk/res-auto"
    android:layout_margin="5dp"
    card_view:cardCornerRadius="5dp"
    card_view:cardElevation="10dp"
    android:layout_height="200dp">

    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <ImageView
            android:layout_width="150dp"
            android:layout_height="150dp"
            android:id="@+id/teacherImageView"
            android:padding="5dp"
            android:src="@drawable/placeholder" />

    <LinearLayout
        android:orientation="vertical"
        android:layout_width="wrap_content"
        android:layout_height="match_parent">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceSmall"
            android:text="Teacher Name"
            android:id="@+id/nameTextView"
            android:padding="5dp"
            android:textColor="@color/colorAccent" />
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceSmall"
            android:text="Date"
            android:id="@+id/dateTextView"
            android:padding="5dp"
            android:textStyle="italic"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceSmall"
            android:text="Description"
            android:minLines="2"
            android:textStyle="italic"
            android:id="@+id/descriptionTextView"
            android:padding="5dp"/>

    </LinearLayout>
    </LinearLayout>

</android.support.v7.widget.CardView>                                                                                                                                                  