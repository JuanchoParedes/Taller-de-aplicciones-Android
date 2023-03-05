package com.example.tallersemana7.di

import com.example.tallersemana7.MyApplication
import com.example.tallersemana7.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class, UIModule::class, DataModule::class]
)
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    fun inject(activity: MainActivity)
}