package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val service: API = RetrofitClient().getService().create(API::class.java)

            service.login(binding.email.text.toString(), binding.password.text.toString())
                .enqueue(object : retrofit2.Callback<DTO>{
                    override fun onResponse(call: Call<DTO>, response: Response<DTO>) {
                        if(response.body() != null) {
                            binding.message.text = response.body()!!.message
                            binding.user.text = response.body()!!.user.toString()
                            binding.userName.text = response.body()!!.userName
                            binding.linear.visibility = View.VISIBLE
                            binding.loginLinear.visibility = View.GONE
                        }
                    }

                    override fun onFailure(call: Call<DTO>, t: Throwable) {
                        Log.d("TEST", t.toString())
                    }
                })
        }

        binding.register.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
    }
}