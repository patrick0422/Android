package com.example.yacebook

import java.time.LocalDateTime

data class Comment(
    val writer: User,
    val postedTime: LocalDateTime,
    val content: String,
    val likeCount: Int
)
