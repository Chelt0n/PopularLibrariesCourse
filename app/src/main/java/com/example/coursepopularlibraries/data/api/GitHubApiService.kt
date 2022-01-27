package com.example.coursepopularlibraries.data.api

import com.example.coursepopularlibraries.data.model.GitHubUsers
import retrofit2.Call
import retrofit2.http.GET

interface GitHubApiService {
    @GET("users")
    fun getGitHubUsers():Call<List<GitHubUsers>>
}
