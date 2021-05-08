package com.example.retrofitpractice

import retrofit2.Call
import retrofit2.http.*

interface Service {
    val post: String

    @GET("posts/{post}")
    fun getPost(@Path("post") post: String): Call<Post>

    @GET("posts")
    fun getPosts(): Call<ArrayList<Post>>


    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>

    @GET("users")
    fun getUsers(): Call<ArrayList<User>>
}