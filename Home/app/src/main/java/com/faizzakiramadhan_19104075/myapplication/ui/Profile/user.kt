//package com.faizzakiramadhan_19104075.myapplication.ui.Profile
//
//import androidx.appcompat.app.AppCompatActivity
//import android.widget.EditText
//import com.google.firebase.firestore.FirebaseFirestore
//import android.os.Bundle
//import com.faizzakiramadhan_19104075.myapplication.R
//import android.text.TextUtils
//import android.widget.Button
//import com.google.firebase.firestore.CollectionReference
//import com.faizzakiramadhan_19104075.myapplication.ui.Profile.All_user
//import com.google.android.gms.tasks.OnSuccessListener
//import android.widget.Toast
//import com.google.android.gms.tasks.OnFailureListener
//
//class user : AppCompatActivity() {
//    // creating variables for our edit text
//    private var namaProfile: EditText? = null
//    private var descProfile: EditText? = null
//    private var namaLengkap: EditText? = null
//    private var namaPanggilan: EditText? = null
//    private var alamat: EditText? = null
//    private var alamatEmail: EditText? = null
//    private var noWhatsapp: EditText? = null
//    private var sosmedIg: EditText? = null
//
//    // creating variable for button
//    private val saveProfile: Button? = null
//
//    // creating a strings for storing
//    // our values from edittext fields.
//    private var NamaProfile: String? = null
//    private var DescProfile: String? = null
//    private var NamaLengkap: String? = null
//    private var NamaPanggilan: String? = null
//    private var Alamat: String? = null
//    private var AlamatEmail: String? = null
//    private var NoWhatsapp: String? = null
//    private var SosmedIg: String? = null
//
//    // creating a variable
//    // for firebasefirestore.
//    private var db: FirebaseFirestore? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // getting our instance
//        // from Firebase Firestore.
//        db = FirebaseFirestore.getInstance()
//
//        // initializing our edittext and buttons
//        namaProfile = findViewById(R.id.nama_profile)
//        descProfile = findViewById(R.id.desc_profile)
//        namaLengkap = findViewById(R.id.nama_lengkap)
//        namaPanggilan = findViewById(R.id.nama_panggilan)
//        alamat = findViewById(R.id.alamat_profile)
//        alamatEmail = findViewById(R.id.alamat_email)
//        noWhatsapp = findViewById(R.id.no_whatsapp)
//        sosmedIg = findViewById(R.id.sosmed_ig)
//
//
//        // adding on click listener for button
//        saveProfile!!.setOnClickListener {
//            // getting data from edittext fields.
//            NamaProfile = namaProfile.getText().toString()
//            DescProfile = descProfile.getText().toString()
//            NamaLengkap = namaLengkap.getText().toString()
//            NamaPanggilan = namaPanggilan.getText().toString()
//            Alamat = alamat.getText().toString()
//            AlamatEmail = alamatEmail.getText().toString()
//            NoWhatsapp = noWhatsapp.getText().toString()
//            SosmedIg = sosmedIg.getText().toString()
//
//
//            // validating the text fields if empty or not.
//            if (TextUtils.isEmpty(NamaProfile)) {
//                namaProfile.setError("Please enter Course Name")
//            } else if (TextUtils.isEmpty(DescProfile)) {
//                descProfile.setError("Please enter Course Description")
//            } else if (TextUtils.isEmpty(NamaLengkap)) {
//                namaLengkap.setError("Please enter Course Duration")
//            } else if (TextUtils.isEmpty(NamaPanggilan)) {
//                namaPanggilan.setError("Please enter Course Description")
//            } else if (TextUtils.isEmpty(Alamat)) {
//                alamat.setError("Please enter Course Duration")
//            } else if (TextUtils.isEmpty(AlamatEmail)) {
//                alamatEmail.setError("Please enter Course Description")
//            } else if (TextUtils.isEmpty(NoWhatsapp)) {
//                noWhatsapp.setError("Please enter Course Duration")
//            } else if (TextUtils.isEmpty(SosmedIg)) {
//                sosmedIg.setError("Please enter Course Duration")
//            } else {
//                // calling method to add data to Firebase Firestore.
//                addDataToFirestore(
//                    NamaProfile!!,
//                    DescProfile!!,
//                    NamaLengkap!!,
//                    NamaPanggilan!!,
//                    Alamat!!,
//                    AlamatEmail!!,
//                    NoWhatsapp!!,
//                    SosmedIg!!
//                )
//            }
//        }
//    }
//
//    private fun addDataToFirestore(
//        NamaProfile: String,
//        DescProfile: String,
//        NamaLengkap: String,
//        NamaPanggilan: String,
//        Alamat: String,
//        AlamatEmail: String,
//        NoWhatsapp: String,
//        SosmedIg: String
//    ) {
//
//        // creating a collection reference
//        // for our Firebase Firetore database.
//        val dbCourses = db!!.collection("User Profile")
//
//        // adding our data to our courses object class.
//        val courses = All_user(
//            NamaProfile,
//            DescProfile,
//            NamaLengkap,
//            NamaPanggilan,
//            Alamat,
//            AlamatEmail,
//            NoWhatsapp,
//            SosmedIg
//        )
//
//        // below method is use to add data to Firebase Firestore.
//        dbCourses.add(courses).addOnSuccessListener { // after the data addition is successful
//            // we are displaying a success toast message.
//            Toast.makeText(
//                this@user,
//                "Your Course has been added to Firebase Firestore",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//            .addOnFailureListener { e -> // this method is called when the data addition process is failed.
//                // displaying a toast message when data addition is failed.
//                Toast.makeText(this@user, "Fail to add course \n$e", Toast.LENGTH_SHORT).show()
//            }
//    }
//}