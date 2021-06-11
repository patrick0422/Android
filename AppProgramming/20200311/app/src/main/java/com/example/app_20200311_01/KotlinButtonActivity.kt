package com.example.app_20200311_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app_20200311_01.databinding.ActivityKotlinButtonBinding

class KotlinButtonActivity : AppCompatActivity() {
    val binding by lazy { ActivityKotlinButtonBinding.inflate(layoutInflater) }

    val listener1 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            binding.tv1.text = "1번 버튼"
        }
    }
    val listener2 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            binding.tv1.text = "2번 버튼"
        }
    }
    val listener3 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            when(v?.id) {
                binding.btn3.id -> {
                    binding.tv1.text = "3번 버튼"
                }
                binding.btn4.id -> {
                    binding.tv1.text = "4번 버튼"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener { listener1 }
        binding.btn2.setOnClickListener { listener2 }
        binding.btn3.setOnClickListener { listener3 }
    }
}