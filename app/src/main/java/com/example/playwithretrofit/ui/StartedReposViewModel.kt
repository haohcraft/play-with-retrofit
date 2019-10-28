package com.example.playwithretrofit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playwithretrofit.data.JsonPlaceholderRepository
import com.example.playwithretrofit.data.StartedRepo
import kotlinx.coroutines.launch

class StartedReposViewModel( private val jsonPlaceholderRepository: JsonPlaceholderRepository): ViewModel() {
    private val _repo = MutableLiveData<StartedRepo>()
    val startedRepo: LiveData<StartedRepo> = _repo

    fun getStartedRepoById(id: Int) {
        viewModelScope.launch {
            val repo = jsonPlaceholderRepository.getStartedRepoById(id)
            _repo.value = repo
        }
    }
}