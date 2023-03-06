package com.example.tallersemana7.ui.customersbymanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.domain.usecase.GetCustomersByManagerUseCase

class CustomersByManagerViewModelFactory(
    private val useCase: GetCustomersByManagerUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomersByManagerViewModel::class.java)) {
            return CustomersByManagerViewModel(
                useCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}