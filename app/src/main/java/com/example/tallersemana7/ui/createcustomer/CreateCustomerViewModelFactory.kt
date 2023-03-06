package com.example.tallersemana7.ui.createcustomer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateCustomerViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateCustomerViewModel::class.java)) {
            return CreateCustomerViewModel(

            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}