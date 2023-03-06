package com.example.tallersemana7.ui.createcustomer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.domain.usecase.CreateCustomerUseCase

class CreateCustomerViewModelFactory(
    private val useCase: CreateCustomerUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateCustomerViewModel::class.java)) {
            return CreateCustomerViewModel(
                useCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}