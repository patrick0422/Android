package com.example.retrofitpractice

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Post (
    val id: Int,
    val title: String,
    val time: String,
    val writer: Int,
    val content: String,
)