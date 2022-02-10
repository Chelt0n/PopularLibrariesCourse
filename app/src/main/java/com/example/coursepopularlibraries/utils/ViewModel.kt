package com.example.coursepopularlibraries.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T

    }

inline fun <VM : ViewModel> viewModels(owner: ViewModelStoreOwner, crossinline f: () -> VM) =
    lazy {
        ViewModelProvider(owner, viewModelFactory(f))[ViewModel::class.java] as VM
    }


