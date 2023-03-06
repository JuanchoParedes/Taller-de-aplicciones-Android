package com.example.tallersemana7.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.domain.usecase.GetManagerUseCase
import com.example.tallersemana7.domain.usecase.LogoutUseCase

class MainViewModelFactory(
    private val logoutUseCase: LogoutUseCase,
    private val getManagerUseCase: GetManagerUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                logoutUseCase,
                getManagerUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}