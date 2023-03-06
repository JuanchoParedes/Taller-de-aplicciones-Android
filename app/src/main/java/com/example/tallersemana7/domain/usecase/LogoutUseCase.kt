package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.ManagerRepository
import io.reactivex.rxjava3.core.Completable

class LogoutUseCase(
    private val repository: ManagerRepository
) {

    operator fun invoke(): Completable = repository.logout()
}