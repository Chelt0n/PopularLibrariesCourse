package com.example.coursepopularlibraries.data.repository

import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.data.model.User
import com.example.coursepopularlibraries.data.source.NetworkDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailsRepositoryImpl(private val networkDataSource: NetworkDataSource) : DetailsRepository {
    override fun getGitHubUsers(): Single<List<GitHubUsers>> =
        networkDataSource.getGitHubUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getUserRepositories(user: String): Single<List<User>> =
        networkDataSource.getUserRepositories(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}