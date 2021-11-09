package com.example.apisandbox.retrofit

import com.example.apisandbox.retrofit.model.AlbumList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums(): Response<AlbumList>
    @GET("/albums")
    suspend fun getAlbumsOf(@Query("userId")userId: String): Response<AlbumList>
}