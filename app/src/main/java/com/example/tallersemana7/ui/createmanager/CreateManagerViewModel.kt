package com.example.tallersemana7.ui.createmanager

import androidx.lifecycle.ViewModel
import com.example.tallersemana7.domain.usecase.CreateManagerUseCase

class CreateManagerViewModel(
    private val createManagerUseCase: CreateManagerUseCase
) : ViewModel() {


    fun createManager(userName: String, password: String) {
        createManagerUseCase.invoke(userName, password)
    }
}