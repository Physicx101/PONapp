package com.example.fauziw97.ponapp.ui.sports

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.fauziw97.ponapp.data.model.Sports
import com.example.fauziw97.ponapp.data.repo.FirebaseDatabaseRepo
import com.example.fauziw97.ponapp.data.repo.SportsRepo

class SportsViewModel : ViewModel() {

    private var sports: MutableLiveData<List<Sports>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val repository = SportsRepo()

    fun getSports(): LiveData<List<Sports>> {
        loadSports()
        return sports
    }


    override fun onCleared() {
        repository.removeListener()
    }

    private fun loadSports() {
        repository.addListener(object : FirebaseDatabaseRepo.FirebaseDatabaseRepositoryCallback<Sports> {
            override fun onSuccess(result: List<Sports>) {
                sports.value = result
                isLoading.postValue(false)
            }

            override fun onError(e: Exception) {
                sports.value = null
                isLoading.postValue(true)
            }
        })
    }
}