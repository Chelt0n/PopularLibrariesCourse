package com.example.coursepopularlibraries.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursepopularlibraries.data.model.User
import com.example.coursepopularlibraries.data.repository.DetailsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        repository.getUserRepositories(user, callback)
    }


    private val callback = object : Callback<List<User>> {
        override fun onResponse(
            call: Call<List<User>>,
            response: Response<List<User>>
        ) {
            liveData.value = AppStateUser.Success(response.body()!!)
        }

        override fun onFailure(call: Call<List<User>>, t: Throwable) {
            liveData.value = AppStateUser.Error(Throwable("error"))
        }
    }

}