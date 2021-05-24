package com.example.kotlinfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kotlinfirebase.databinding.ActivityUserBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient

class UserActivity : AppCompatActivity() {
    val binding by lazy { ActivityUserBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        if (account != null) {
            if (account.photoUrl != null)
                Log.d("Yang", account.photoUrl.toString())

            // Glide를 통해 프로필 사진 로드
            Glide.with(this)
                    .load(account.photoUrl)
                    .into(binding.userImg)

            binding.userEmail.text = account.email
        }
        else
            startActivity(Intent(this, LoginActivity::class.java))

        binding.btnLogout.setOnClickListener {  }
    }
}