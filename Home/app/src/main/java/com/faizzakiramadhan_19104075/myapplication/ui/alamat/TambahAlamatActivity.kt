package com.faizzakiramadhan_19104075.myapplication.ui.alamat

import com.faizzakiramadhan_19104075.myapplication.ui.alamat.MyDatabaseHelper.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.faizzakiramadhan_19104075.myapplication.R
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.MyDatabaseHelper

class TambahAlamatActivity : AppCompatActivity() {
    var kategori_input: EditText? = null
    var alamat_input: EditText? = null
    var pages_input: EditText? = null
    var add_alamat: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_alamat)
        kategori_input = findViewById(R.id.kategori_input)
        alamat_input = findViewById(R.id.alamat_input)
        pages_input = findViewById(R.id.pages_input)
        add_alamat = findViewById(R.id.add_alamat_button)

        add_alamat?.setOnClickListener(View.OnClickListener {
            val myDB = MyDatabaseHelper(this@TambahAlamatActivity)
            myDB.addAlamat(kategori_input?.getText().toString().trim {
                it <= ' ' },
                alamat_input?.getText().toString().trim { it <= ' ' },
                Integer.valueOf(pages_input?.getText().toString().trim { it <= ' ' }))
        })
    }
}