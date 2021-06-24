package com.example.letmeroom

import android.content.Context
import android.util.Log
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Question::class], version = 1)
abstract class QuestionDatabase: RoomDatabase() {
    abstract fun dao(): QuestionDao

    companion object {
        private var instance: QuestionDatabase? = null

        @Synchronized
        fun getInstance(context: Context): QuestionDatabase? {
            if (instance == null) {
                synchronized(QuestionDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuestionDatabase::class.java,
                        "questions"
                    ).addCallback(object: RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                        }
                    }).allowMainThreadQueries().build()
                }
            }
            return instance
        }

    }
}