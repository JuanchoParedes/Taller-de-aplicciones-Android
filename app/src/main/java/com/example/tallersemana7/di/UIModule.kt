package com.example.tallersemana7.di

import com.example.tallersemana7.domain.usecase.CreateManagerUseCase
import com.example.tallersemana7.domain.usecase.FindManagerUseCase
import com.example.tallersemana7.domain.usecase.LogInUseCase
import com.example.tallersemana7.ui.createmanager.CreateManagerViewModelFactory
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
}