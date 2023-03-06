package com.example.tallersemana7.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.domain.usecase.FindManagerUseCase

class SplashViewModelFactory(
    private val findManagerUseCase: FindManagerUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(
                findManagerUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}