package com.example.coursepopularlibraries.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursepopularlibraries.data.api.GitHubApiRetrofit
import com.example.coursepopularlibraries.data.model.GitHubUsers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListOfUsersViewModel(
    private val retrofitImp: GitHubApiRetrofit = GitHubApiRetrofit()
) : ViewModel() {
    private val liveData: MutableLiveData<AppStateGitHubUsers> = MutableLiveData()

    fun getGitHubUsers():LiveData<AppStateGitHubUsers> {
        sendServerRequest()
        return liveData
    }

    private fun sendServerRequest() {
        liveData.value = AppStateGitHubUsers.Loading(null)
        requestUsers()
    }

    private fun requestUsers() {
        val callback = object : Callback<List<GitHubUsers>>{
            override fun onResponse(call: Call<List<GitHubUsers>>, response: Response<List<GitHubUsers>>) {
                liveData.value = AppStateGitHubUsers.Success(response.body()!!)
            }

            override fun onFailure(call: Call<List<GitHubUsers>>, t: Throwable) {
                liveData.value = AppStateGitHubUsers.Error(Throwable("error"))
            }
        }
        retrofitImp.getGitHubService().getGitHubUsers().enqueue(callback)
    }

}