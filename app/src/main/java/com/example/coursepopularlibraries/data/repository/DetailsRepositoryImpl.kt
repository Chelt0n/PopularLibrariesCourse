package com.example.coursepopularlibraries.data.repository

import com.example.coursepopularlibraries.data.source.NetworkDataSource

class DetailsRepositoryImpl(private val networkDataSource: NetworkDataSource) : DetailsRepository {
    override fun getGitHubUsers() =
        networkDataSource.getGitHubUsers()

    override fun getUserRepositories(user: String) =
        networkDataSource.getUserRepositories(user)

}