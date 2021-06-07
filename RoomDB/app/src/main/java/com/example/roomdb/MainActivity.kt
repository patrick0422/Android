package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    lateinit var binding : ActivityMainBinding

    lateinit var dao : Dao
    private lateinit var  userList: List<UserDataBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.main = this

        dao = DataBase.getInstance(this)!!.dao()

        setText()
    }

    fun setText() {
        userList = dao.getAll()

        if (userList.isNotEmpty()) {
            email.value = userList[0].email
            password.value = userList[0].password
        }
    }

    fun login() {
        dao.delete()
        dao.insert(UserDataBase(
            id = 0,
            email = email.value.toString(),
            password = password.value.toString()
            )
        )

        Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()
    }
}