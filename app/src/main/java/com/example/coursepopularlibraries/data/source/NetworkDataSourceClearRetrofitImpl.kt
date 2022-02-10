package com.example.coursepopularlibraries.data.source

import com.example.coursepopularlibraries.data.api.GitHubApiRetrofit
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class NetworkDataSourceClearRetrofitImpl(private val retrofit: GitHubApiRetrofit) :
    NetworkDataSource {

    override fun getGitHubUsers(): Single<List<GitHubUsers>> = Single.fromCallable {
        val response = retrofit.getGitHubServiceWithoutRx().getGitHubUsers().execute()
        handleResponse(response)
    }

    override fun getUserRepositories(user: String): Single<List<User>> = Single.fromCallable {
        val response = retrofit.getGitHubServiceWithoutRx().getRepositories(user).execute()
        handleResponse(response)
    }

    private fun <T> handleResponse(response: Response<T>): T {
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        }
        val message = response.message()
        if (message.isNullOrEmpty()) {
            throw Throwable("Unidentified error")
        } else {
            throw Throwable(message)
        }
    }
}