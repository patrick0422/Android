package com.example.circlemenudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.circlemenudemo.databinding.ActivityMainBinding
import com.ramotion.circlemenu.CircleMenuView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.circleMenuView.eventListener
    }

    private var cmEventListener = CircleMenuView.EventListener()
}