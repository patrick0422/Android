package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDataBase(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String
)