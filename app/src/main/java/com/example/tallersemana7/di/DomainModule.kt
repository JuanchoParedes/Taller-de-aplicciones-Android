package com.example.tallersemana7.di

import com.example.tallersemana7.domain.repository.ManagerRepository
import com.example.tallersemana7.domain.usecase.CreateManagerUseCase
import com.example.tallersemana7.domain.usecase.FindManagerUseCase
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
}