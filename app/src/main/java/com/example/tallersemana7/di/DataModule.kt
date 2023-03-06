package com.example.tallersemana7.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.example.tallersemana7.data.db.DATABASE_NAME
import com.example.tallersemana7.data.db.DataBase
import com.example.tallersemana7.data.db.ManagerDao
import com.example.tallersemana7.data.preferences.SharedPrefsDataSource
import com.example.tallersemana7.data.repository.CustomerRepositoryImpl
import com.example.tallersemana7.data.repository.ManagerRepositoryImpl
import com.example.tallersemana7.domain.repository.CustomerRepository
import com.example.tallersemana7.domain.repository.ManagerRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModule::class])
class DataModule {

    @Singleton
    @Provides
    internal fun provideDataBase(
        application: Application
    ) = Room.databaseBuilder(application, DataBase::class.java, DATABASE_NAME).build()

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
        dataSource: SharedPrefsDataSource,
        database: DataBase
    ): ManagerRepository {
        return ManagerRepositoryImpl(dataSource, database.managerDao())
    }

    @Singleton
    @Provides
    internal fun provideCustomerRepository(
        database: DataBase
    ): CustomerRepository = CustomerRepositoryImpl(database.customerDao())
}