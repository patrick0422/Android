package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding.btnRegister.setOnClickListener {
            val service: API = RetrofitClient().getService().create(API::class.java)

            service.join(
                binding.userId.text.toString(),
                binding.userPwd.text.toString(),
                binding.userAge.text.toString(),
                binding.userGender.text.toString(),
                binding.userStudyfield.text.toString())
                .enqueue(object : retrofit2.Callback<DaTaOo>{
                    override fun onResponse(call: Call<DaTaOo>, response: Response<DaTaOo>) {
                        if(response.body() != null) {
                            Toast.makeText(this@RegisterActivity, "성공", Toast.LENGTH_SHORT).show()

//                            binding.message.text = response.body()!!.message
//                            binding.user.text = response.body()!!.user.toString()
//                            binding.userName.text = response.body()!!.userName
//                            binding.linear.visibility = View.VISIBLE
//                            binding.loginLinear.visibility = View.GONE
                        }
                    }

                    override fun onFailure(call: Call<DaTaOo>, t: Throwable) {
                        Log.d("TEST", t.toString())
                    }
                })
        }
    }
}