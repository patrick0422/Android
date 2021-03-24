package com.example.fanpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
                              this.finish()
        }, 3000)
    }
}
class TestThread : Thread() {
    override fun run() {
        val thread = Thread.currentThread()
    }

}