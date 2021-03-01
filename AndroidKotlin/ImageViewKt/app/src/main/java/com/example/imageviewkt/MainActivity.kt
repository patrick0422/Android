package com.example.imageviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var i = 1
        bt_toast.setOnClickListener {
            if (i == 1) {
                iv_profile.setImageResource(R.drawable.sunglasssquare)
                i = 0
            } else {
                iv_profile.setImageResource(R.drawable.smilesquare)
                 i = 1
            }
            Toast.makeText(this@MainActivity, "Toast Message Printed.", Toast.LENGTH_SHORT).show()
        }
    }
}