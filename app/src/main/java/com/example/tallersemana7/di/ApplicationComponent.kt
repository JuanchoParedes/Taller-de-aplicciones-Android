package com.example.tallersemana7.di

import com.example.tallersemana7.MyApplication
import dagger.Component

@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)
}