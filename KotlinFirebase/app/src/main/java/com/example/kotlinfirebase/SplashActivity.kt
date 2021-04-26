package com.example.kotlinfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // initConn()

        Thread.sleep(1000)

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//            reload();
//        }
//    }

    fun initConn() {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
    }
}