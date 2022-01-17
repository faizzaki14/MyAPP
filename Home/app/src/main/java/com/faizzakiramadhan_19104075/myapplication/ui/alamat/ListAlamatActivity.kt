package com.faizzakiramadhan_19104075.myapplication.ui.alamat

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.MyDatabaseHelper
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.CustomAdapter
import android.os.Bundle
import com.faizzakiramadhan_19104075.myapplication.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.TambahAlamatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import java.util.ArrayList

class ListAlamatActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var add_button_alamat: FloatingActionButton? = null
    var myDB: MyDatabaseHelper? = null
    var alamat_id: ArrayList<String>? = null
    var alamat_kategori: ArrayList<String>? = null
    var alamat_alamat: ArrayList<String>? = null
    var alamat_pages: ArrayList<String>? = null
    var customAdapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_alamat)
        recyclerView = findViewById(R.id.recyclerViewAlamat)
        add_button_alamat = findViewById(R.id.add_button_alamat)
        add_button_alamat?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ListAlamatActivity, TambahAlamatActivity::class.java)
            startActivity(intent)
        })
        myDB = MyDatabaseHelper(this@ListAlamatActivity)
        alamat_id = ArrayList()
        alamat_kategori = ArrayList()
        alamat_alamat = ArrayList()
        alamat_pages = ArrayList()

        storeDataInArray()

        customAdapter = CustomAdapter(this@ListAlamatActivity, this, alamat_id!!, alamat_kategori!!,
            alamat_alamat!!, alamat_pages!!)
        recyclerView!!.setAdapter(customAdapter)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this@ListAlamatActivity))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            recreate()
        }
    }

    fun storeDataInArray() {
        val cursor = myDB!!.readAllData()
        if (cursor!!.count == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show()
        } else {
            while (cursor.moveToNext()) {
                alamat_id!!.add(cursor.getString(0))
                alamat_kategori!!.add(cursor.getString(1))
                alamat_alamat!!.add(cursor.getString(2))
                alamat_pages!!.add(cursor.getString(3))
            }
        }
    }
}