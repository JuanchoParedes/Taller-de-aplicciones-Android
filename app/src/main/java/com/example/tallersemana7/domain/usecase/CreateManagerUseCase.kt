package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.ManagerRepository

class CreateManagerUseCase(
    private val repository: ManagerRepository
) {

    operator fun invoke(userName: String, password: String) {
        repository.createManager(userName, password)
    }
}