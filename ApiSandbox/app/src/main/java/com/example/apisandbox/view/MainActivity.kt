package com.example.apisandbox.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.astritveliu.boom.Boom
import com.example.apisandbox.AlbumAdapter
import com.example.apisandbox.R
import com.example.apisandbox.databinding.ActivityMainBinding
import com.example.apisandbox.retrofit.AlbumService
import com.example.apisandbox.retrofit.RetrofitInstance
import com.example.apisandbox.retrofit.model.AlbumList
import com.example.apisandbox.util.Constants.Companion.TAG
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var resultData: LiveData<Response<AlbumList>>

    private val service = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnGet.setOnClickListener {
            val keyWord = binding.etSearch.text.toString()

            if (keyWord.isBlank())
                getData()
            else
                getData(keyWord)
        }

        initRecyclerView()
        getData()

        Boom()
    }

    private fun initRecyclerView() {
        binding.rankingView.layoutManager = LinearLayoutManager(this)
        binding.rankingView.adapter = AlbumAdapter(arrayListOf())
    }

    private fun getData() {
        resultData = liveData {
            val response = service.getAlbums()
            Log.d(TAG, "onSearch: ${response.body()}")
            emit(response)
        }
        observeData()
    }
    private fun getData(keyWord: String) {
        resultData = liveData {
            val response = service.getAlbumsOf(keyWord)
            Log.d(TAG, "onSearch: ${response.body()}")
            emit(response)
        }
        observeData()
    }
    private fun observeData() {
        resultData.observe(this, {
            if (it.isSuccessful && it.body() != null) {
                (binding.rankingView.adapter as AlbumAdapter).itemList = ArrayList(it.body()!!)
                binding.rankingView.adapter!!.notifyDataSetChanged()
            }
        })
    }
}