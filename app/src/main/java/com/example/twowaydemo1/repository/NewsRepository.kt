package com.example.twowaydemo1.repository

import com.example.twowaydemo1.api.RetrofitInstance
import com.example.twowaydemo1.db.ArticleDataBase
import com.example.twowaydemo1.models.Article
import retrofit2.Retrofit

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) =
        db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}