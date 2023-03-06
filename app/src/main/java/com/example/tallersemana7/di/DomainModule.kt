package com.example.tallersemana7.di

import com.example.tallersemana7.domain.repository.CustomerRepository
import com.example.tallersemana7.domain.repository.ManagerRepository
import com.example.tallersemana7.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataModule::class])
class DomainModule {

    @Singleton
    @Provides
    internal fun provideFindManagerUseCase(
        repository: ManagerRepository
    ): FindManagerUseCase = FindManagerUseCase(
        repository
    )

    @Singleton
    @Provides
    internal fun provideCreateManagerUseCase(
        repository: ManagerRepository
    ): CreateManagerUseCase = CreateManagerUseCase(repository)

    @Singleton
    @Provides
    internal fun provideLogInUseCase(
        repository: ManagerRepository
    ): LogInUseCase = LogInUseCase(repository)

    @Singleton
    @Provides
    internal fun provideCreateCustomerUseCase(
        repository: CustomerRepository
    ): CreateCustomerUseCase = CreateCustomerUseCase(
        repository
    )

    @Singleton
    @Provides
    internal fun provideGetCustomersByManagerUseCase(
        customerRepository: CustomerRepository
    ): GetCustomersByManagerUseCase = GetCustomersByManagerUseCase(
        customerRepository
    )

    @Singleton
    @Provides
    internal fun provideLogoutUseCase(
        repository: ManagerRepository
    ): LogoutUseCase = LogoutUseCase(repository)


    @Singleton
    @Provides
    internal fun provideGetManagerUseCase(
        managerRepository: ManagerRepository
    ): GetManagerUseCase = GetManagerUseCase(managerRepository)

}