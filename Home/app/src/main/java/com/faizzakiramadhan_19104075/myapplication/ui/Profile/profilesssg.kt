//package com.faizzakiramadhan_19104075.myapplication.ui.Profile
//
//import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.storage.UploadTask
//import com.google.firebase.storage.StorageReference
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.firestore.FirebaseFirestore
//import com.faizzakiramadhan_19104075.myapplication.ui.Profile.All_UserMember
//import android.os.Bundle
//import com.faizzakiramadhan_19104075.myapplication.R
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.storage.FirebaseStorage
//import android.content.Intent
//import com.faizzakiramadhan_19104075.myapplication.ui.Profile.profilesssg
//import android.app.Activity
//import com.squareup.picasso.Picasso
//import android.content.ContentResolver
//import android.net.Uri
//import android.os.Handler
//import android.webkit.MimeTypeMap
//import android.text.TextUtils
//import android.view.View
//import android.widget.*
//import kotlin.Throws
//import com.google.android.gms.tasks.OnCompleteListener
//import com.google.android.gms.tasks.OnSuccessListener
//import com.faizzakiramadhan_19104075.myapplication.Fragment1
//import com.google.firebase.firestore.DocumentReference
//import java.lang.Exception
//import java.util.HashMap
//
//class profilesssg : AppCompatActivity() {
//    var nama_profile: EditText? = null
//    var desc_profile: EditText? = null
//    var nama_lengkap: EditText? = null
//    var nama_panggilan: EditText? = null
//    var alamat_profile: EditText? = null
//    var alamat_email: EditText? = null
//    var sosmed_ig: EditText? = null
//    var button: Button? = null
//    var imageView: ImageView? = null
//    var progressBar: ProgressBar? = null
//    var imageUri: Uri? = null
//    var uploadTask: UploadTask? = null
//    var storageReference: StorageReference? = null
//    var database = FirebaseDatabase.getInstance()
//    var databaseReference: DatabaseReference? = null
//    var db = FirebaseFirestore.getInstance()
//    var documentReference: DocumentReference? = null
//    var member: All_UserMember? = null
//    var currentUserId: String? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_profile)
//        member = All_UserMember()
//        imageView = findViewById(R.id.image_view)
//        nama_lengkap = findViewById(R.id.nama_lengkap)
//        desc_profile = findViewById(R.id.desc_profile)
//        nama_profile = findViewById(R.id.nama_profile)
//        nama_panggilan = findViewById(R.id.nama_panggilan)
//        alamat_profile = findViewById(R.id.alamat_profile)
//        alamat_email = findViewById(R.id.alamat_email)
//        sosmed_ig = findViewById(R.id.sosmed_ig)
//        val user = FirebaseAuth.getInstance().currentUser
//        currentUserId = user!!.uid
//        documentReference = db.collection("user").document(currentUserId!!)
//        storageReference = FirebaseStorage.getInstance().getReference("Profile images")
//        databaseReference = database.getReference("All User")
//        button!!.setOnClickListener { uploadData() }
//        imageView.setOnClickListener(View.OnClickListener {
//            val intent = Intent()
//            intent.type = "image/*"
//            intent.action = Intent.ACTION_GET_CONTENT
//            startActivityForResult(intent, PICK_IMAGE)
//        })
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        try {
//            if (requestCode == PICK_IMAGE || resultCode == RESULT_OK || data != null || data!!.getData() != null) {
//                imageUri = data!!.data
//                Picasso.get().load(imageUri).into(imageView)
//            }
//        } catch (e: Exception) {
//            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun getFiletxt(uri: Uri?): String? {
//        val contentResolver = contentResolver
//        val mimeTypeMap = MimeTypeMap.getSingleton()
//        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!))
//    }
//
//    private fun uploadData() {
//        val nameprofile = nama_profile!!.text.toString()
//        val descprofile = desc_profile!!.text.toString()
//        val namalengkap = nama_lengkap!!.text.toString()
//        val namapanggilan = nama_panggilan!!.text.toString()
//        val alamat = alamat_profile!!.text.toString()
//        val alamatemail = alamat_email!!.text.toString()
//        val sosmedig = sosmed_ig!!.text.toString()
//        if (!TextUtils.isEmpty(nameprofile) || !TextUtils.isEmpty(descprofile) || !TextUtils.isEmpty(
//                namalengkap
//            ) || !TextUtils.isEmpty(namapanggilan) || !TextUtils.isEmpty(alamat) || !TextUtils.isEmpty(
//                alamatemail
//            ) || !TextUtils.isEmpty(sosmedig) || imageUri != null
//        ) {
//            progressBar!!.visibility = View.VISIBLE
//            val reference = storageReference!!.child(
//                System.currentTimeMillis().toString() + "." + getFiletxt(imageUri)
//            )
//            uploadTask = reference.putFile(imageUri!!)
//            val urlTask = uploadTask!!.continueWithTask { task ->
//                if (!task.isSuccessful) {
//                    throw task.exception!!
//                }
//                reference.downloadUrl
//            }.addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val downloadUri = task.result
//                    val profile: MutableMap<String, String> = HashMap()
//                    profile["nama_profile"] = nameprofile
//                    profile["desc_Profile"] = descprofile
//                    profile["nama_lengkap"] = namalengkap
//                    profile["nama_panggilan"] = namapanggilan
//                    profile["alamat"] = alamat
//                    profile["alamat_email"] = alamatemail
//                    profile["sosmed_ig"] = sosmedig
//                    profile["privacy"] = "Public"
//                    member!!.setNameprofile(nameprofile)
//                    member!!.setDescprofile(descprofile)
//                    member!!.setNamalengkap(namalengkap)
//                    member!!.setNamapanggilan(namapanggilan)
//                    member!!.setAlamat(alamat)
//                    member!!.setAlamatemail(alamatemail)
//                    member!!.setSosmedig(sosmedig)
//                    member!!.setUrl(downloadUri.toString())
//                    databaseReference!!.child(currentUserId!!).setValue(member)
//                    documentReference!!.set(profile)
//                        .addOnSuccessListener {
//                            progressBar!!.visibility = View.INVISIBLE
//                            val handler = Handler()
//                            handler.postDelayed({
//                                val intent = Intent(this@profilesssg, Fragment1::class.java)
//                                startActivity(intent)
//                            }, 2000)
//                        }
//                }
//            }
//        } else {
//            Toast.makeText(this, "isi dulu ya", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    companion object {
//        private const val PICK_IMAGE = 1
//    }
//}