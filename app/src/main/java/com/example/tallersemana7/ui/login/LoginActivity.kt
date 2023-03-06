package com.example.tallersemana7.ui.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tallersemana7.R
import com.example.tallersemana7.ui.showAlertDialog

class LoginActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var btCreateManager: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btLogin)
        btCreateManager = findViewById(R.id.btCreateManager)

        btCreateManager.setOnClickListener {

        }

        btLogin.setOnClickListener {
            val username = etName.text.toString().trim()
            val password =  etPassword.text.toString().trim()
            if (username.isNotEmpty() &&
                password.isNotEmpty())

            else showAlertDialog(
                getString(R.string.alert_dialog_invalid_fields_body)
            )
        }

    }
}