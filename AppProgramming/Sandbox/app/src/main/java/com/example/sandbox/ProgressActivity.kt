package com.example.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.sandbox.databinding.ActivityMainBinding
import com.example.sandbox.databinding.ActivityProgressBinding
import kotlin.concurrent.thread

class ProgressActivity : AppCompatActivity() {
    private val binding by lazy { ActivityProgressBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        thread(start=true){
            Thread.sleep(3000)
            runOnUiThread {
                showProgress(false)
            }
        }
    }

    private fun showProgress(show: Boolean) {
        binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }
}