package com.example.kotlinfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth
//        Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        Thread.sleep(1000)
        if(currentUser != null)
            startActivity(Intent(this, MainActivity::class.java))
        else
            startActivity(Intent(this, LoginActivity::class.java))

        finish()
    }
}