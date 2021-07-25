package com.example.yacebook

import java.time.LocalDateTime

data class Post(
    val writer: User,
    val postedTime: LocalDateTime,
    val content: String,
    val likeCount: Int,
    val commentList: List<Comment>,
    val commentCount: Int = commentList.size
)