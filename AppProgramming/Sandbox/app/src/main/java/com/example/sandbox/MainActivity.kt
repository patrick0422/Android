package com.example.sandbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Button
import com.example.sandbox.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnTimer.setOnClickListener { startActivity(Intent(this, TimerActivity::class.java)); }
        binding.btnProgress.setOnClickListener { startActivity(Intent(this, ProgressActivity::class.java)); }
    }
}