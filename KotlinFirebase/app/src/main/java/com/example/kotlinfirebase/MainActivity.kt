package com.example.kotlinfirebase

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kotlinfirebase.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(FixturesFragment(), NewsFragment(), NotificationFragment(), SettingFragment())
        val adapter = FragmentAdapter(supportFragmentManager, 1)
        adapter.fragmentList = fragmentList
        binding.pager.adapter = adapter
    }
}