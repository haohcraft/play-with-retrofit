package com.example.playwithretrofit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.playwithretrofit.data.JsonPlaceholderRepository

/**
 * Note: ViewModelProvide requires a viewModelFactory in order to initiate
 */
class StartedReposViewModelFactory(private val jsonPlaceholderRepository: JsonPlaceholderRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StartedReposViewModel(jsonPlaceholderRepository) as T
    }
}