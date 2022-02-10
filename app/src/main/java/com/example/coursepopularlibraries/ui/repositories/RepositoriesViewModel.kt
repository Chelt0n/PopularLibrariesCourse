package com.example.coursepopularlibraries.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursepopularlibraries.data.repository.DetailsRepository

class RepositoriesViewModel(
    private val repository: DetailsRepository
) : ViewModel() {
    private val liveData: MutableLiveData<AppStateUser> = MutableLiveData()

    fun getUserRepositories(user: String): LiveData<AppStateUser> {
        sendServerRequest(user)
        return liveData
    }

    private fun sendServerRequest(user: String) {
        liveData.value = AppStateUser.Loading(null)
        repository.getUserRepositories(user).subscribe({
            liveData.value = AppStateUser.Success(it)
        }, {
            liveData.value = AppStateUser.Error(it)
        })
    }

}