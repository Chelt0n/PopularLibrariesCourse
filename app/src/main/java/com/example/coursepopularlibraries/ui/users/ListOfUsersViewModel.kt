package com.example.coursepopularlibraries.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.repository.DetailsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListOfUsersViewModel(
    private val repository: DetailsRepository
) : ViewModel() {
    private val liveData: MutableLiveData<AppStateGitHubUsers> = MutableLiveData()

    fun getGitHubUsers(): LiveData<AppStateGitHubUsers> {
        sendServerRequest()
        return liveData
    }

    private fun sendServerRequest() {
        liveData.value = AppStateGitHubUsers.Loading(null)
        repository.getGitHubUsers().subscribe({
            liveData.value = AppStateGitHubUsers.Success(it)
        }, {
            liveData.value = AppStateGitHubUsers.Error(it)
        })
    }
}