package com.example.tallersemana7.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tallersemana7.R

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel.findManagerLiveData.observe(this) { managerIsLogged ->
            if (managerIsLogged) goToCustomerActivity()
            else goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        TODO("Not yet implemented")
    }

    private fun goToCustomerActivity() {
        TODO("Not yet implemented")
    }
}