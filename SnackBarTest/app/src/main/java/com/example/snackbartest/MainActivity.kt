package com.example.snackbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.snackbartest.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.main = this
    }
    fun showSnackbarMsg() {
        var snack = Snackbar.make(binding.mainLayout, "Snackbar 메시지입니다.", Snackbar.LENGTH_INDEFINITE)
        snack.setAction("확인") { snack.dismiss() }

        snack.show()
    }
}