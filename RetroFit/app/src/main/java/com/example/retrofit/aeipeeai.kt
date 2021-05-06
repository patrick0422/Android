package com.example.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {
    @FormUrlEncoded
    @POST("user/login")
    fun login(
        @Field("userEmail") userEmail : String,
        @Field("userPwd") userPwd : String
    ) : Call<DTO>

    @POST("user/join")
    fun join(
        @Field("userEmail") userEmail: String,
        @Field("userPwd") userPwd: String,
        @Field("userAge") userAge: String,
        @Field("userGender") userGender: String,
        @Field("userStudyfield") userStudyfield: String,
    ) : Call<DaTaOo>
}