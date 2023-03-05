package com.example.tallersemana7

import android.app.Application
import com.example.tallersemana7.di.ApplicationComponent
import com.example.tallersemana7.di.ApplicationModule
import com.example.tallersemana7.di.ComponentProvider
import com.example.tallersemana7.di.DaggerApplicationComponent

class MyApplication: Application(), ComponentProvider {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component.inject(this)

    }

    override fun getComponent(): ApplicationComponent {
        return component
    }
}