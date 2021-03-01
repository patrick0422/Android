package com.example.listviewkt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     var UserList = arrayListOf<User>(
         User(R.drawable.batman, "양태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "엄태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "김태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "박태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "이태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "정태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "최태웅", "17", "안녕하세요"),
         User(R.drawable.batman, "성태웅", "17", "안녕하세요")
     )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = arrayOf("사과", "배", "자두", "딸기", "키위")

        // context는 한 액티비티의 모든 정보를 담고 있다.
        val Adapter = UserAdapter(this, UserList)
        listView.adapter = Adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()

        }
    }
}