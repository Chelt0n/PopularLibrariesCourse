package com.example.coursepopularlibraries.data.repository

import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import com.example.coursepopularlibraries.data.source.NetworkDataSource
import retrofit2.Callback

class DetailsRepositoryImpl(private val networkDataSource: NetworkDataSource) : DetailsRepository {
    override fun getGitHubUsers(callback: Callback<List<GitHubUsers>>) {
        networkDataSource.getGitHubUsers(callback)
    }

    override fun getUserRepositories(user: String, callback: Callback<List<User>>) {
        networkDataSource.getUserRepositories(user,callback)
    }
}