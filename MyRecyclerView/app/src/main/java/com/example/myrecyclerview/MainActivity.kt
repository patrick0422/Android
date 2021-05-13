package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var postList = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        for (i in 1..50)
            postList.add(Post(i, "제목 $i","$i", i, "$i"))

        binding.rView.adapter = RecyclerPostAdapter(postList)
        binding.rView.layoutManager = LinearLayoutManager(this)
    }
}