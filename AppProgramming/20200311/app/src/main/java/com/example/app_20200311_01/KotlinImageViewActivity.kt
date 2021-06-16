package com.example.app_20200311_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_20200311_01.databinding.ActivityKotlinImageViewBinding

class KotlinImageViewActivity : AppCompatActivity() {
    val binding by lazy { ActivityKotlinImageViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}