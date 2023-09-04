package com.example.twowaydemo1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twowaydemo1.api.NewsAPi
import com.example.twowaydemo1.models.NewsResponse
import com.example.twowaydemo1.repository.NewsRepository
import com.example.twowaydemo1.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1


    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, pageNumber = breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsReponse(response))
    }

    private fun handleBreakingNewsReponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Sucess(it)
            }
        }
        return Resource.Error(response.message())
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuery, pageNumber = searchNewsPage)
        searchNews.postValue(handleSearchNewsReponse(response))
    }

    private fun handleSearchNewsReponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Sucess(it)
            }
        }
        return Resource.Error(response.message())
    }
}