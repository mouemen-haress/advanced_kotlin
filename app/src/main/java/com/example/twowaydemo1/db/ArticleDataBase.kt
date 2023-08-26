package com.example.twowaydemo1.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.twowaydemo1.Article

@Database(entities = [Article::class],
version = 1)
abstract class ArticleDataBase:RoomDatabase() {
    abstract fun getArticleDao():ArticleDao

    companion object{
        @Volatile
        private var instance:ArticleDataBase?=null
        private val LOCK = Any()
         operator fun invoke()

    }
}