package com.example.coursepopularlibraries.data.repository

import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import retrofit2.Callback

interface DetailsRepository {
    fun getGitHubUsers(callback: Callback<List<GitHubUsers>>)
    fun getUserRepositories(user: String, callback: Callback<List<User>>)
}