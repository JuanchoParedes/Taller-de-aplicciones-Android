package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.ManagerRepository
import io.reactivex.rxjava3.core.Single

class GetManagerUseCase(
    private val managerRepository: ManagerRepository
) {

    operator fun invoke(): Single<String> = managerRepository.getManager()
}