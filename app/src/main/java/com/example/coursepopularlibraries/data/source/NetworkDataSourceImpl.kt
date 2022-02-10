package com.example.coursepopularlibraries.data.source

import com.example.coursepopularlibraries.data.api.GitHubApiRetrofit
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Callback

class NetworkDataSourceImpl(private val retrofit: GitHubApiRetrofit) : NetworkDataSource {
    override fun getGitHubUsers(): Single<List<GitHubUsers>> =
        retrofit.getGitHubService()
            .getGitHubUsers()


    override fun getUserRepositories(user: String): Single<List<User>> =
        retrofit.getGitHubService()
            .getRepositories(user)
}