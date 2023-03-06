package com.example.tallersemana7.ui.createmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.domain.usecase.CreateManagerUseCase

class CreateManagerViewModelFactory(
    private val createManagerUseCase: CreateManagerUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateManagerViewModel::class.java)) {
            return CreateManagerViewModel(
                createManagerUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}