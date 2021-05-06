package com.example.retrofit

class kt {
}

fun main() {
    val list = mutableListOf<Int>(3,4,2,1,5,7,4,1,1,2,1,6)

    for (i in list.indices) {
        for (j in i until list.size -1) {

            if (list[i] > list[j]) {
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp
            }
        }
    }

    list.forEach {
        println(it)
    }
}