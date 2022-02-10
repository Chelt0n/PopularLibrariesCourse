package com.example.coursepopularlibraries.data.api

import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiService {
    @GET("users")
    fun getGitHubUsers():Call<List<GitHubUsers>>
    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user:String):Call<List<User>>
}
