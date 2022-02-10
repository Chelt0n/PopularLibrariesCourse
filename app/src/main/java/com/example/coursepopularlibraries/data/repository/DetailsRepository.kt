package com.example.coursepopularlibraries.data.repository

import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Callback

interface DetailsRepository {
    fun getGitHubUsers(): Single<List<GitHubUsers>>
    fun getUserRepositories(user: String): Single<List<User>>
}