package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b_toSub.setOnClickListener() {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("msg", tv_main01.text.toString())
            startActivity(intent)
        }
    }
}