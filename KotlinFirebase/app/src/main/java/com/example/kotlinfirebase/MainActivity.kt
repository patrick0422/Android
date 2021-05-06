package com.example.kotlinfirebase

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlinfirebase.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var auth: FirebaseAuth


    var textList = arrayOf("경기 일정", "뉴스", "알림", "환경설정")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.pager){tab, position->
            tab.text = textList[position]
        }.attach()


        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.btnUser.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    };
}