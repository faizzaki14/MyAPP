package com.faizzakiramadhan_19104075.myapplication.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faizzakiramadhan_19104075.myapplication.databinding.TaskItemBinding
import com.faizzakiramadhan_19104075.myapplication.ui.dashboard.DataModel.TaskModel
import kotlinx.android.synthetic.main.carddd.view.*
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(val taskList: ArrayList<TaskModel>, val context: Context) :
    RecyclerView.Adapter<TaskAdapter.MyHoler>() {


    class MyHoler(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHoler {

        val binding = TaskItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyHoler(binding)
    }

    override fun onBindViewHolder(holder: MyHoler, position: Int) {

        val task = taskList[position]
        with(holder) {
            binding.tvTaskName.text = task.task_name
            binding.chBox.isChecked = task.isChecked

        }

    }

    override fun getItemCount(): Int {



        return taskList.size
    }

}