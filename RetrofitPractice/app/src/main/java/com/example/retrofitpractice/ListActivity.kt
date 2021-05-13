package com.example.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitpractice.databinding.ActivityListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {
    val binding by lazy { ActivityListBinding.inflate(layoutInflater) }

    var postList = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        initList()

        for(i in 1..20)
            postList.add(Post(i, "제목: $i", "시간: $i", i, "내용: $i"))

        binding.postView.adapter = PostAdapter(postList)
        binding.postView.layoutManager = LinearLayoutManager(this)
    }

    private fun initList() {
        val service = Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/patrick0422/myJSON/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Service::class.java)

        service.getPosts()
                .enqueue(object : Callback<ArrayList<Post>> {
                    override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                        if (response.isSuccessful) {
//                            postList = response.body() as ArrayList<Post>
                            binding.postView.adapter = PostAdapter(response.body() as ArrayList<Post>)

                            Log.d("getPost()", "$postList, SIZE: ${postList.size}")
                        }
                    }
                    override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                        Log.d("getPost()", t.toString())
                        Toast.makeText(this@ListActivity, "불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
                    }
                })
    }
}