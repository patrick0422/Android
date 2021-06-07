package com.example.retrofitpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofitpractice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var index = 1

    val service = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/patrick0422/myJSON/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Service::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPost(index)
        setContentView(binding.root)

        binding.btnPrev.setOnClickListener { getPost(--index) }
        binding.btnNext.setOnClickListener { getPost(++index) }
        binding.btnReturn.setOnClickListener { startActivity(Intent(this, ListActivity::class.java)) }
    }


    private fun getPost(index: Int) {
        Log.d("index", index.toString())
        service.getPost(index.toString())
            .enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    val post = response.body()

                    if (post != null) {
                        getUser(post.id)
                        binding.postTitle.text = post.title
                        binding.postDate.text = post.time
                        binding.postContent.text = post.content
                    }
                    else {
                        Log.d("getPost()", "post is null")
                        Toast.makeText(this@MainActivity, "불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Log.d("getPost()", t.toString())
                    Toast.makeText(this@MainActivity, "불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
                }

            })
    }
    fun getUser(id: Int): User? {
        var user = User(-1, "user", "1234")
        service.getUser(id.toString())
                .enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        user = response.body() as User
                        binding.postWriter.text = user.name
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Log.d("onFailure", t.toString())

                        user = User(-1, "ERROR", "ERROR")
                    }

                })
        return user
    }
}