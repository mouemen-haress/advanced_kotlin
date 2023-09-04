package com.example.twowaydemo1.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.twowaydemo1.models.Article

@Dao
interface  ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("Select * from articles")
     fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}