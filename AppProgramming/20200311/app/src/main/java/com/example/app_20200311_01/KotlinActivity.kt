package com.example.app_20200311_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.example.app_20200311_01.databinding.ActivityKotlinBinding

class KotlinActivity : AppCompatActivity() {
    val binding by lazy { ActivityKotlinBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tv1.setBackgroundColor(Color.RED)
        binding.tv1.append(" 화이팅")
        binding.tv1.textSize = 30F

        binding.tv2.text = "집에 가고싶어요"
        binding.tv2.textSize = 30F
        binding.tv3.text = "Hi"
        binding.tv3.textSize = 30F
        binding.tv4.text = "Bye"
        binding.tv4.textSize = 30F
        binding.tv5.text = "하이바이"
        binding.tv5.textSize = 30F



    }
}