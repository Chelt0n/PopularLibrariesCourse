package com.example.coursepopularlibraries.ui.repositories

import com.example.coursepopularlibraries.data.model.User

sealed class AppStateUser {

    data class Success(val serverResponseData: List<User>) : AppStateUser()

    data class Error(val error: Throwable) : AppStateUser()

    data class Loading(val progress: Int?) : AppStateUser()

}
