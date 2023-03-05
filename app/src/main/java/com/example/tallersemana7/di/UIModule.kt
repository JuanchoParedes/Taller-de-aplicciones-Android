package com.example.tallersemana7.di

import com.example.tallersemana7.domain.usecase.FindManagerUseCase
import com.example.tallersemana7.ui.main.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DomainModule::class])
class UIModule {

    @Singleton
    @Provides
    internal fun provideMainViewModelFactory(
        findManagerUseCase: FindManagerUseCase
    ): MainViewModelFactory = MainViewModelFactory(
        findManagerUseCase
    )
}