package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    fun getService() : Retrofit = Retrofit.Builder()
            .baseUrl("https://kjw03.loca.lt/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}