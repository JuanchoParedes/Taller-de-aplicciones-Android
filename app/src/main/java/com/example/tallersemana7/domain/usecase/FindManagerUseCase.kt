package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.ManagerRepository

class FindManagerUseCase(
    private val repository: ManagerRepository
) {

    operator fun invoke(): Boolean = repository.findManager()
}