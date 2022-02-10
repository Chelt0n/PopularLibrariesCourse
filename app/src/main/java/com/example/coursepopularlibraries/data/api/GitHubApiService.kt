package com.example.coursepopularlibraries.data.api

import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiService {
    @GET("users")
    fun getGitHubUsers():Single<List<GitHubUsers>>
    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user:String):Single<List<User>>
}
