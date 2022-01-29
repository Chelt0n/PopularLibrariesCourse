package com.example.coursepopularlibraries

import android.app.Application
import com.example.coursepopularlibraries.data.api.GitHubApiRetrofit
import com.example.coursepopularlibraries.data.repository.DetailsRepository
import com.example.coursepopularlibraries.data.repository.DetailsRepositoryImpl
import com.example.coursepopularlibraries.data.source.NetworkDataSourceImpl

class App : Application() {
    val repository: DetailsRepository = DetailsRepositoryImpl(
        NetworkDataSourceImpl(
            GitHubApiRetrofit()
        )
    )
}