package com.faizzakiramadhan_19104075.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.faizzakiramadhan_19104075.myapplication.databinding.FragmentAllMenuBinding


class AllMenu : Fragment() {

    private var _binding : FragmentAllMenuBinding?= null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAllMenuBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
            _binding = null
    }
}