package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.ManagerRepository

class LogInUseCase(
    private val repository: ManagerRepository
) {

    operator fun invoke(userName: String, password: String) {
        repository.logIn(userName, password)
    }
}