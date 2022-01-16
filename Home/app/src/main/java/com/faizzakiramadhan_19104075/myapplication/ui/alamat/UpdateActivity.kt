package com.faizzakiramadhan_19104075.myapplication.ui.alamat

import com.faizzakiramadhan_19104075.myapplication.ui.alamat.MyDatabaseHelper.*

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.faizzakiramadhan_19104075.myapplication.R
import android.widget.Toast
import android.content.DialogInterface
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class UpdateActivity : AppCompatActivity() {
    var kategori_input: EditText? = null
    var alamat_input: EditText? = null
    var pages_input: EditText? = null
    var update_alamat_button: Button? = null
    var delete_alamat_button: Button? = null
    var id: String? = null
    var kategori: String? = null
    var alamat: String? = null
    var pages: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        kategori_input = findViewById(R.id.kategori_input2)
        alamat_input = findViewById(R.id.alamat_input2)
        pages_input = findViewById(R.id.pages_input2)
        update_alamat_button = findViewById(R.id.update_alamat_button)
        delete_alamat_button = findViewById(R.id.delete_alamat_button)
        andSetIntentData
        val ab = supportActionBar
        ab?.setTitle(kategori)
        update_alamat_button?.setOnClickListener(View.OnClickListener {
            val myDB = MyDatabaseHelper(this@UpdateActivity)
            kategori = kategori_input?.getText().toString().trim { it <= ' ' }
            alamat = alamat_input?.getText().toString().trim { it <= ' ' }
            pages = pages_input?.getText().toString().trim { it <= ' ' }
            myDB.updateData(id!!, kategori, alamat, pages)
        })
        delete_alamat_button?.setOnClickListener(View.OnClickListener { confirmDialog() })
    }
    //            Getting data from intent

    //            Setting Intent Data
    val andSetIntentData: Unit
        get() {
            if (intent.hasExtra("id") && intent.hasExtra("kategori") &&
                intent.hasExtra("alamat") && intent.hasExtra("pages")
            ) {
//            Gettig data from intent
                id = intent.getStringExtra("id")
                kategori = intent.getStringExtra("kategori")
                alamat = intent.getStringExtra("alamat")
                pages = intent.getStringExtra("pages")

//            Setting Intent Data
                kategori_input!!.setText(kategori)
                alamat_input!!.setText(alamat)
                pages_input!!.setText(pages)
            } else {
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show()
            }
        }

    fun confirmDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Hapus $kategori ?")
        builder.setMessage("Apakah Anda yakin ingin menghapus $kategori ?")
        builder.setPositiveButton("Ya") { dialog, which ->
            val myDB = MyDatabaseHelper(this@UpdateActivity)
            myDB.deleteOneRow(id!!)
            finish()
        }
        builder.setNegativeButton("Tidak") { dialog, which -> }
        builder.create().show()
    }
}