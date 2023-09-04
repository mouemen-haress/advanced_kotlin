package com.example.twowaydemo1.db

import android.content.Context
import androidx.room.*
import com.example.twowaydemo1.models.Article

@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Converter::class)


abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDataBase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also {
                instance = it
            }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_db.db"
            ).build()

    }
}