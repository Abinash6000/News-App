package com.example.newsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.News
import com.example.newsapp.network.NewsApi
import kotlinx.coroutines.launch

enum class NewsApiStatus {
    LOADING, ERROR, DONE
}

class NewsViewModel : ViewModel() {

    private val _status = MutableLiveData<NewsApiStatus>()
    val status: LiveData<NewsApiStatus> get() = _status

    private val _news = MutableLiveData<News>()
    val news: MutableLiveData<News> get() = _news

    fun getNews() {
        viewModelScope.launch {
            _status.value = NewsApiStatus.LOADING
            try {
                _news.value = NewsApi.retrofitService.getNewsHeadLines()
                _status.value = NewsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = NewsApiStatus.ERROR
                _news.value = News(null, null)
            }
        }
    }
}