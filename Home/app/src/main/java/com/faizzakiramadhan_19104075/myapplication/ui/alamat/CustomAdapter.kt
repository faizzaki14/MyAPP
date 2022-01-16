package com.faizzakiramadhan_19104075.myapplication.ui.alamat

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.CustomAdapter.MyViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import com.faizzakiramadhan_19104075.myapplication.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.UpdateActivity
import android.widget.TextView
import android.widget.LinearLayout
import java.util.ArrayList

class CustomAdapter internal constructor(
    var activity: Activity,
    private val context: Context,
    private val alamat_id: ArrayList<*>,
    private val alamat_kategori: ArrayList<*>,
    private val alamat_alamat: ArrayList<*>,
    private val alamat_pages: ArrayList<*>
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.my_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.id_alamat_txt.text = alamat_id[position].toString()
        holder.kategori_alamat_txt.text = alamat_kategori[position].toString()
        holder.alamat_alamat_txt.text = alamat_alamat[position].toString()
        holder.pages_alamat_txt.text = alamat_pages[position].toString()
        holder.mainLayout.setOnClickListener {
            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("id", alamat_id[position].toString())
            intent.putExtra("kategori", alamat_kategori[position].toString())
            intent.putExtra("alamat", alamat_alamat[position].toString())
            intent.putExtra("pages", alamat_pages[position].toString())
            activity.startActivityForResult(intent, 1)
        }
    }

    override fun getItemCount(): Int {
        return alamat_id.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id_alamat_txt: TextView
        var kategori_alamat_txt: TextView
        var alamat_alamat_txt: TextView
        var pages_alamat_txt: TextView
        var mainLayout: LinearLayout

        init {
            id_alamat_txt = itemView.findViewById(R.id.id_alamat_txt)
            kategori_alamat_txt = itemView.findViewById(R.id.kategori_alamat_txt)
            alamat_alamat_txt = itemView.findViewById(R.id.alamat_alamat_txt)
            pages_alamat_txt = itemView.findViewById(R.id.pages_alamat_txt)
            mainLayout = itemView.findViewById(R.id.mainLayout)
        }
    }
}