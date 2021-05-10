package com.example.retrofitpractice

class PostItem(
    var id: Int,
    var title: String,
    var time: String,
    var writer: Int,
    var content: String,
) {
    override fun toString(): String ="id: $id\n" + "title: $title\n" + "time: $time\n" + "writer: $writer\n" + "content: $content\n"


}