package com.example.kotlinfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        InitConn()
        CheckPermission()

        Thread.sleep(1500)

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    fun InitConn() {

    }
    fun CheckPermission() {

    }
}