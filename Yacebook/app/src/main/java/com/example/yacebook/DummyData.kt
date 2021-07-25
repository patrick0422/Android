package com.example.yacebook

import android.annotation.SuppressLint
import java.time.LocalDateTime

class DummyData {
    companion object {
        private val userList = listOf<User>(
            User("양태웅", "profileUrl", "Some Link here"),
            User("송시현", "profileUrl", "Some Link here"),
            User("김태영", "profileUrl", "Some Link here"),
            User("임창규", "profileUrl", "Some Link here"),
        )
        @SuppressLint("NewApi")
        private val commentList = listOf<Comment>(
            Comment(userList[1], LocalDateTime.now(), "너는 짱이야", 1),
            Comment(userList[0], LocalDateTime.now(), "나는 짱이야", 3),
            Comment(userList[2], LocalDateTime.now(), "우린 짱이야", 6),
            Comment(userList[1], LocalDateTime.now(), "나는 장이야", 75),
            Comment(userList[0], LocalDateTime.now(), "나는 짱구야", 10),
            Comment(userList[3], LocalDateTime.now(), "나는 장어야", 4),
            Comment(userList[0], LocalDateTime.now(), "나는 짱아야", 25),
            Comment(userList[0], LocalDateTime.now(), "나는 구이야", 2),
            Comment(userList[3], LocalDateTime.now(), "나는 마이야", 7),
        )
        @SuppressLint("NewApi")
        val postList = listOf<Post>(
            Post(userList[0], LocalDateTime.now(), "조직문화를 좋아하는 임창규씨.", 55, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "TMI) 아무거나 뒤에 창을 붙이면 말이 된다", 63, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "디디순살양념", 81, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "강약중간약", 7, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "홈트는 지옥이다", 78, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "간장공장공장장!", 2, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "Test!!", 31, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "제가 이 글의 내용을 채우는것에 대한 허락을 받는 것에 대하여 여쭈어 보는 것을 여쭈어 보아도 괜찮겠습니까?", 55, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "하지만, But! 비 유 티~ 송시현의 Download 목록에는...", 55, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "찍창", 22, commentList, commentList.size),
            Post(userList[0], LocalDateTime.now(), "창트북", 65, commentList, commentList.size),
        )
    }
}