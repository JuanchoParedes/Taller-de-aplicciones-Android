package com.example.tallersemana7.di

import com.example.tallersemana7.MyApplication
import com.example.tallersemana7.ui.createcustomer.CreateCustomerFragment
import com.example.tallersemana7.ui.createmanager.CreateManagerFragment
import com.example.tallersemana7.ui.customersbymanager.CustomersByManagerFragment
import com.example.tallersemana7.ui.login.LoginActivity
import com.example.tallersemana7.ui.login.LoginFragment
import com.example.tallersemana7.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class, UIModule::class, DataModule::class]
)
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    fun inject(activity: SplashActivity)

    fun inject(fragment: LoginFragment)

    fun inject(fragment: CreateManagerFragment)

    fun inject(fragment: CustomersByManagerFragment)

    fun inject(fragment: CreateCustomerFragment)
}