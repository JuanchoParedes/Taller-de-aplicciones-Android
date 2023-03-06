package com.example.tallersemana7.ui.customersbymanager

import com.example.tallersemana7.domain.usecase.CreateCustomerUseCase
import com.example.tallersemana7.ui.BaseViewModel

class CustomersByManagerViewModel(
private val useCase: CreateCustomerUseCase
) : BaseViewModel() {
}