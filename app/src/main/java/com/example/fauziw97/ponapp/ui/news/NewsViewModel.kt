package com.example.fauziw97.ponapp.ui.news

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.fauziw97.ponapp.data.model.News
import com.example.fauziw97.ponapp.data.repo.FirebaseDatabaseRepo
import com.example.fauziw97.ponapp.data.repo.NewsRepo

class NewsViewModel : ViewModel() {

    private var news: MutableLiveData<List<News>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val repository = NewsRepo()

    fun getNews(): LiveData<List<News>> {
        loadNews()
        return news
    }


    override fun onCleared() {
        repository.removeListener()
    }

    private fun loadNews() {
        repository.addListener(object : FirebaseDatabaseRepo.FirebaseDatabaseRepositoryCallback<News> {
            override fun onSuccess(result: List<News>) {
                news.value = result
                isLoading.postValue(false)
            }

            override fun onError(e: Exception) {
                news.value = null
                isLoading.postValue(true)
            }
        })
    }
}