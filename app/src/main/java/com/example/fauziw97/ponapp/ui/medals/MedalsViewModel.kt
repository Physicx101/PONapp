package com.example.fauziw97.ponapp.ui.medals

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.fauziw97.ponapp.data.model.Medals
import com.example.fauziw97.ponapp.data.repo.FirebaseDatabaseRepo
import com.example.fauziw97.ponapp.data.repo.MedalsRepo

class MedalsViewModel : ViewModel() {

    private var medals: MutableLiveData<List<Medals>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val repository = MedalsRepo()

    fun getMedals(): LiveData<List<Medals>> {
        medals = MutableLiveData()
        loadMedals()
        return medals
    }



    override fun onCleared() {
        repository.removeListener()
    }

    private fun loadMedals() {
        repository.addListener(object : FirebaseDatabaseRepo.FirebaseDatabaseRepositoryCallback<Medals> {
            override fun onSuccess(result: List<Medals>) {
                medals.value = result
                isLoading.postValue(false)
            }

            override fun onError(e: Exception) {
                medals.value = null
                isLoading.postValue(true)
            }
        })
    }
}