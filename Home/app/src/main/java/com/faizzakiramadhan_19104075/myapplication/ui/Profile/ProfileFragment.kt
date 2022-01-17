package com.faizzakiramadhan_19104075.myapplication.ui.Profile

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.faizzakiramadhan_19104075.myapplication.databinding.FragmentProfileBinding
import com.faizzakiramadhan_19104075.myapplication.ui.dashboard.DataModel.TaskModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.carddd.*
import kotlinx.android.synthetic.main.fragment_profile.*



class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    lateinit var auth: FirebaseAuth
    lateinit var db : FirebaseFirestore
    var nama_profile: EditText? = null
    var desc_profile: EditText? = null
    var nama_lengkap: EditText? = null
    var nama_panggilan: EditText? = null
    var alamat_profile: EditText? = null
    var alamat_email: EditText? = null
    var no_whatsapp: EditText? = null
    var sosmed_ig: EditText? = null
    var button: Button? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding!!.imageButtonShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val url = "https://web.whatsapp.com/"
            intent.putExtra("Share This",url)

            val chooser = Intent.createChooser(intent, "Share Using : ")
            startActivity(chooser)
        }
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        var currentUser = auth.currentUser


        binding.saveProfile.setOnClickListener{
            val namaProfile = binding.namaProfile.text.toString().trim()
            val descProfile = binding.descProfile.text.toString().trim()
            val namaLengkap = binding.namaLengkap.text.toString().trim()
            val namaPanggilan = binding.namaPanggilan.text.toString().trim()
            val alamatProfile = binding.alamatProfile.text.toString().trim()
            val alamatEmail = binding.alamatEmail.text.toString().trim()
            val noWhatsapp = binding.noWhatsapp.text.toString().trim()
            val sosmedIg = binding.sosmedIg.text.toString().trim()


            if (
                !TextUtils.isEmpty(namaProfile) || !TextUtils.isEmpty(descProfile) || !TextUtils.isEmpty(
                namaLengkap
            ) || !TextUtils.isEmpty(namaPanggilan) || !TextUtils.isEmpty(alamatProfile) || !TextUtils.isEmpty(
                alamatEmail
            ) || !TextUtils.isEmpty(noWhatsapp)|| !TextUtils.isEmpty(sosmedIg)
            ){
                binding.namaProfile.setError("gaboleh Kosong Sayang")
                binding.descProfile.setError("gaboleh Kosong Sayang")
                binding.namaLengkap.setError("gaboleh Kosong Sayang")
                binding.namaPanggilan.setError("gaboleh Kosong Sayang")
                binding.alamatProfile.setError("gaboleh Kosong Sayang")
                binding.alamatEmail.setError("gaboleh Kosong Sayang")
                binding.sosmedIg.setError("gaboleh Kosong Sayang")

                return@setOnClickListener
            }

            val users = HashMap<String,Any>()
            users["namaProfile"] = namaProfile
            users["descProfile"] = descProfile
            users["namaLengkap"] = namaLengkap
            users["namaPanggilan"] = namaPanggilan
            users["alamat"] = alamat
            users["alamatEmail"] = alamatEmail
            users["noWhatsapp"] = noWhatsapp
            users["sosmedIg"] = sosmedIg



            db.collection("User_Profile")
                .add(users)
                .addOnSuccessListener {
                    Toast.makeText(requireActivity(), "task save!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireActivity(), "task not save!", Toast.LENGTH_SHORT).show()
                    Log.e("Ha", "Error Saving: " + it.message)
                }

        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}