package com.faizzakiramadhan_19104075.myapplication.ui.dashboard

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faizzakiramadhan_19104075.myapplication.databinding.FragmentDashboardBinding
import com.faizzakiramadhan_19104075.myapplication.ui.dashboard.DataModel.TaskModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.task_item.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    lateinit var auth: FirebaseAuth
    lateinit var db : FirebaseFirestore

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        var currentUser = auth.currentUser
        loadAllData(currentUser!!.uid.toString())

        binding.btnAdd.setOnClickListener{
            var task = binding.etTask.text.toString().trim()
            if (task.isEmpty()){
                 binding.etTask.setError("gaboleh Kosong Sayang")
                return@setOnClickListener
            }

            val taskData = TaskModel(task, false, currentUser!!.uid.toString())
            db.collection("All_task")
                .add(taskData)
                .addOnSuccessListener {
                    Toast.makeText(requireActivity(), "task save!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireActivity(), "task not save!", Toast.LENGTH_SHORT).show()
                    Log.e("Ha", "Error Saving: " + it.message)
                }

        }






        binding.refresh.setOnRefreshListener {
            if (binding.refresh.isRefreshing){
                binding.refresh.isRefreshing = false
            }
            loadAllData(currentUser!!.uid)
        }


        return root
    }

     fun loadAllData(userID: String) {

         val tasklist = ArrayList<TaskModel>()

         var ref = db.collection("All_task")
         ref.whereEqualTo("userID", userID)
             .get()
             .addOnSuccessListener {
                 if (it.isEmpty){
                     Toast.makeText(requireActivity(), "Tidak ada data!", Toast.LENGTH_SHORT).show()
                     return@addOnSuccessListener
                 }

                 for (doc in it){
                     val taskModel = doc.toObject(TaskModel::class.java)
                     tasklist.add(taskModel)
                 }

                 binding.rvToDoList.apply {
                     layoutManager =
                         LinearLayoutManager( requireActivity(), RecyclerView.VERTICAL, false)
                     adapter = TaskAdapter(tasklist,  requireActivity())
                 }

             }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}