package com.example.tallersemana7.di

import com.example.tallersemana7.domain.usecase.*
import com.example.tallersemana7.ui.createcustomer.CreateCustomerViewModelFactory
import com.example.tallersemana7.ui.createmanager.CreateManagerViewModelFactory
import com.example.tallersemana7.ui.customersbymanager.CustomersByManagerViewModelFactory
import com.example.tallersemana7.ui.login.LogInViewModelFactory
import com.example.tallersemana7.ui.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DomainModule::class])
class UIModule {

    @Singleton
    @Provides
    internal fun provideMainViewModelFactory(
        findManagerUseCase: FindManagerUseCase
    ): SplashViewModelFactory = SplashViewModelFactory(
        findManagerUseCase
    )

    @Singleton
    @Provides
    internal fun provideLogInViewModelFactory(
        useCase: LogInUseCase
    ): LogInViewModelFactory = LogInViewModelFactory(
        useCase
    )

    @Singleton
    @Provides
    internal fun provideCreateManagerViewModelFactory(
        createManagerUseCase: CreateManagerUseCase
    ): CreateManagerViewModelFactory = CreateManagerViewModelFactory(
        createManagerUseCase
    )

    @Singleton
    @Provides
    internal fun provideCustomersByManagerViewModelFactory(
        useCase: GetCustomersByManagerUseCase
    ): CustomersByManagerViewModelFactory = CustomersByManagerViewModelFactory(
        useCase
    )

    @Singleton
    @Provides
    internal fun provideCreateCustomerViewModelFactory(
        useCase: CreateCustomerUseCase
    ): CreateCustomerViewModelFactory = CreateCustomerViewModelFactory(
        useCase
    )

}