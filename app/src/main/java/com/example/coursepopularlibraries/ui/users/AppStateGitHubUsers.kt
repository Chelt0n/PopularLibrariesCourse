package com.example.coursepopularlibraries.ui.users

import com.example.coursepopularlibraries.data.model.GitHubUsers

sealed class AppStateGitHubUsers {

    data class Success(val serverResponseData: List<GitHubUsers>) : AppStateGitHubUsers()

    data class Error(val error: Throwable) : AppStateGitHubUsers()

    data class Loading(val progress: Int?) : AppStateGitHubUsers()

}
