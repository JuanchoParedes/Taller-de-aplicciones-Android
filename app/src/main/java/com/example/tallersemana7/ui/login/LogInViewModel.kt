package com.example.tallersemana7.ui.login

import com.example.tallersemana7.domain.usecase.LogInUseCase
import com.example.tallersemana7.ui.BaseViewModel

class LogInViewModel(
    private val useCase: LogInUseCase
): BaseViewModel() {

    fun logIn(username: String, password: String) {
        useCase.invoke(username, password)
    }
}