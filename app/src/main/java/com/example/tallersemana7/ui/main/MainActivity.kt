package com.example.tallersemana7.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.R
import com.example.tallersemana7.di.ComponentProvider
import com.example.tallersemana7.ui.login.LoginActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = (application as ComponentProvider).getComponent()
        component.inject(this)

        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        mainViewModel.findManagerLiveData.observe(this) { managerIsLogged ->
            if (managerIsLogged) goToCustomerActivity()
            else goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        })
    }

    private fun goToCustomerActivity() {
     //   TODO("Not yet implemented")
    }
}