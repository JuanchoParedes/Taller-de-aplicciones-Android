package com.example.tallersemana7.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tallersemana7.R
import com.example.tallersemana7.di.ComponentProvider
import com.example.tallersemana7.ui.showAlertDialog
import javax.inject.Inject

class LoginFragment: Fragment() {

    private lateinit var etName: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var btCreateManager: Button

    @Inject
    lateinit var factory: LogInViewModelFactory
    private lateinit var viewModel: LogInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = (activity?.application as ComponentProvider).getComponent()
        component.inject(this)

        viewModel = ViewModelProvider(this, factory)[LogInViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etName = view.findViewById(R.id.etName)
        etPassword = view.findViewById(R.id.etPassword)
        btLogin = view.findViewById(R.id.btLogin)
        btCreateManager = view.findViewById(R.id.btCreateManager)

        btCreateManager.setOnClickListener {
            navigateToCreateManager()
        }

        btLogin.setOnClickListener {
            val username = etName.text.toString().trim()
            val password = etPassword.text.toString().trim()
            if (username.isNotEmpty() &&
                password.isNotEmpty()
            ) logIn(username, password)
            else context?.showAlertDialog(
                getString(R.string.alert_dialog_invalid_fields_body)
            )
        }

        viewModel.logInProcessLiveData.observe(viewLifecycleOwner) { loginSuccess ->
            if (loginSuccess) Toast.makeText(context, "logged", Toast.LENGTH_SHORT).show()
            else context?.showAlertDialog(
                getString(R.string.alert_dialog_user_does_not_exists_body)
            )
        }
    }

    private fun navigateToMain() {

    }

    private fun navigateToCreateManager() {
        findNavController().navigate(R.id.action_login_to_create_manager)
    }

    private fun logIn(userName: String, password: String) {
        viewModel.logIn(userName, password)
    }
}