package com.example.tallersemana7.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.tallersemana7.data.preferences.SharedPrefsDataSource
import com.example.tallersemana7.data.repository.ManagerRepositoryImpl
import com.example.tallersemana7.domain.repository.ManagerRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModule::class])
class DataModule {

    @Singleton
    @Provides
    internal fun provideSharedPrefs(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Singleton
    @Provides
    internal fun provideSharedPrefsDataSource(
        sharedPreferences: SharedPreferences
    ): SharedPrefsDataSource = SharedPrefsDataSource(
        sharedPreferences
    )

    @Singleton
    @Provides
    internal fun provideManagerRepository(
        dataSource: SharedPrefsDataSource
    ): ManagerRepository {
        return ManagerRepositoryImpl(dataSource)
    }
}