package com.example.fauziw97.ponapp.ui.schedule

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.fauziw97.ponapp.data.model.Schedule
import com.example.fauziw97.ponapp.data.repo.FirebaseDatabaseRepo
import com.example.fauziw97.ponapp.data.repo.ScheduleRepo

class ScheduleViewModel: ViewModel() {
    private var schedule: MutableLiveData<List<Schedule>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val repository = ScheduleRepo()

    fun getSchedule(): LiveData<List<Schedule>> {
        loadSchedule()
        return schedule
    }


    override fun onCleared() {
        repository.removeListener()
    }

    private fun loadSchedule() {
        repository.addListener(object : FirebaseDatabaseRepo.FirebaseDatabaseRepositoryCallback<Schedule> {
            override fun onSuccess(result: List<Schedule>) {
                schedule.value = result
                isLoading.postValue(false)
            }

            override fun onError(e: Exception) {
                schedule.value = null
                isLoading.postValue(true)
            }
        })
    }
}