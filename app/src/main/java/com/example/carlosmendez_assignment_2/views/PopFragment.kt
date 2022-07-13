package com.example.carlosmendez_assignment_2.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carlosmendez_assignment_2.databinding.FragmentPopBinding

class PopFragment: Fragment() {
    private var _binding: FragmentPopBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}