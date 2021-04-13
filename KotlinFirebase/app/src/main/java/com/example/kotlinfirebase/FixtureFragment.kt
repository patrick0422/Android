package com.example.kotlinfirebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinfirebase.databinding.FragmentFixtureBinding

class FixtureFragment : Fragment() {
    lateinit var binding:FragmentFixtureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFixtureBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }
}