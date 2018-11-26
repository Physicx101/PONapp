package com.example.fauziw97.ponapp.ui.athletes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.fauziw97.ponapp.data.model.Athletes
import com.example.fauziw97.ponapp.data.repo.AthletesRepo
import com.example.fauziw97.ponapp.data.repo.FirebaseDatabaseRepo

class AthletesViewModel: ViewModel() {
    private var athletes: MutableLiveData<List<Athletes>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val repository = AthletesRepo()

    fun getAthletes(): LiveData<List<Athletes>> {
        athletes = MutableLiveData()
        loadAthletes()
        return athletes
    }



    override fun onCleared() {
        repository.removeListener()
    }

    private fun loadAthletes() {
        repository.addListener(object : FirebaseDatabaseRepo.FirebaseDatabaseRepositoryCallback<Athletes> {
            override fun onSuccess(result: List<Athletes>) {
                athletes.value = result
                isLoading.postValue(false)
            }

            override fun onError(e: Exception) {
                athletes.value = null
                isLoading.postValue(true)
            }
        })
    }
}