package com.example.coursepopularlibraries.data.source

import com.example.coursepopularlibraries.data.api.GitHubApiRetrofit
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import retrofit2.Callback

class NetworkDataSourceImpl(private val retrofit: GitHubApiRetrofit) : NetworkDataSource {
    override fun getGitHubUsers(callback: Callback<List<GitHubUsers>>) {
        retrofit.getGitHubService().getGitHubUsers().enqueue(callback)
    }

    override fun getUserRepositories(user: String, callback: Callback<List<User>>) {
        retrofit.getGitHubService().getRepositories(user).enqueue(callback)
    }
}