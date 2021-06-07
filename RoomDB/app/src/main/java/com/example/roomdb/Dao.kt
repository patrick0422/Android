package com.example.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserDataBase>

    @Insert
    fun insert(loginData: UserDataBase)

    @Query("DELETE FROM user")
    fun delete()
}