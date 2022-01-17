//package com.trisnasejati.firestore
//
//import android.R
//import android.annotation.SuppressLint
//import android.app.AlertDialog
//import android.app.ProgressDialog
//import android.content.DialogInterface
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ItemDecoration
//import com.google.android.gms.tasks.OnCompleteListener
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.QueryDocumentSnapshot
//import com.google.firebase.firestore.QuerySnapshot
//import com.google.firebase.firestore.auth.User
//import com.trisnasejati.firestore.adapter.UserAdapter
//import com.trisnasejati.firestore.model.User
//import java.util.ArrayList
//
//class MainActivity : AppCompatActivity() {
//    private var recyclerView: RecyclerView? = null
//    private var btnAdd: FloatingActionButton? = null
//    private val db = FirebaseFirestore.getInstance()
//    private val list: MutableList<User> = ArrayList()
//    private var userAdapter: UserAdapter? = null
//    private var progressDialog: ProgressDialog? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        recyclerView = findViewById(R.id.recycler_view)
//        btnAdd = findViewById(R.id.btn_add)
//        progressDialog = ProgressDialog(this@MainActivity)
//        progressDialog!!.setTitle("Loading")
//        progressDialog!!.setMessage("Mengambil data...")
//        userAdapter = UserAdapter(applicationContext, list)
//        userAdapter.setDialog(object : Dialog() {
//            fun onClick(pos: Int) {
//                val dialogItem = arrayOf<CharSequence>("Edit", "Hapus")
//                val dialog = AlertDialog.Builder(this@MainActivity)
//                dialog.setItems(
//                    dialogItem
//                ) { dialogInterface, i ->
//                    when (i) {
//                        0 -> {
//                            val intent = Intent(
//                                applicationContext,
//                                EditorActivity::class.java
//                            )
//                            intent.putExtra("id", list[pos].getId())
//                            intent.putExtra("name", list[pos].getName())
//                            intent.putExtra("email", list[pos].getEmail())
//                            startActivity(intent)
//                        }
//                        1 -> deleteData(list[pos].getId())
//                    }
//                }
//                dialog.show()
//            }
//        })
//        val layoutManager: RecyclerView.LayoutManager =
//            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//        val decoration: ItemDecoration =
//            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
//        recyclerView.setLayoutManager(layoutManager)
//        recyclerView.addItemDecoration(decoration)
//        recyclerView.setAdapter(userAdapter)
//        btnAdd.setOnClickListener(View.OnClickListener { v: View? ->
//            startActivity(
//                Intent(
//                    applicationContext,
//                    EditorActivity::class.java
//                )
//            )
//        })
//    }
//
//    override fun onStart() {
//        super.onStart()
//        data
//    }
//
//    private val data: Unit
//        private get() {
//            progressDialog!!.show()
//            db.collection("users")
//                .get()
//                .addOnCompleteListener { task ->
//                    list.clear()
//                    if (task.isSuccessful) {
//                        for (document in task.result) {
//                            val user = User(
//                                document.getString("name"),
//                                document.getString("email")
//                            )
//                            user.setId(document.id)
//                            list.add(user)
//                        }
//                        userAdapter.notifyDataSetChanged()
//                    } else {
//                        Toast.makeText(
//                            applicationContext,
//                            "Data gagal di ambil!",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                    progressDialog!!.dismiss()
//                }
//        }
//
//    private fun deleteData(id: String) {
//        progressDialog!!.show()
//        db.collection("users").document(id)
//            .delete()
//            .addOnCompleteListener { task ->
//                if (!task.isSuccessful) {
//                    Toast.makeText(applicationContext, "Data gagal di hapus!", Toast.LENGTH_SHORT)
//                        .show()
//                }
//                progressDialog!!.dismiss()
//                data
//            }
//    }
//}