package com.example.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Button
import com.example.sandbox.databinding.ActivityMainBinding
import kotlin.concurrent.thread

const val TAG = "TestThread"
class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var total = 0
    var started = false

    val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            val minute = String.format("%02d", total / 60)
            val second = String.format("%02d", total % 60)

            binding.tvTimer.text = "$minute:$second"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            started = true
            thread(start = true) {
                while(started) {
                    Thread.sleep(1000)
                    if (started) {
                        total += 1
                        handler?.sendEmptyMessage(0)
                    }
                }
            }
        }
        binding.btnStop.setOnClickListener {
            if (started) {
                started = false
                total = 0
                binding.tvTimer.text = "00:00"
            }
        }
    }
}