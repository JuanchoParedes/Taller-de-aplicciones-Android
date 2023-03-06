package com.example.tallersemana7.ui.createmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tallersemana7.EventObserver
import com.example.tallersemana7.R
import com.example.tallersemana7.di.ComponentProvider
import com.example.tallersemana7.ui.showAlertDialog
import javax.inject.Inject

class CreateManagerFragment : Fragment() {

    private lateinit var btCreateManager: Button
    private lateinit var etName: EditText
    private lateinit var etPassword: EditText

    @Inject
    lateinit var factory: CreateManagerViewModelFactory
    private lateinit var viewModel: CreateManagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = (activity?.application as ComponentProvider).getComponent()
        component.inject(this)

        viewModel = ViewModelProvider(this, factory)[CreateManagerViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_manager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btCreateManager = view.findViewById(R.id.btCreateManager)
        etName = view.findViewById(R.id.etName)
        etPassword = view.findViewById(R.id.etPassword)

        btCreateManager.setOnClickListener {
            val username = etName.text.toString().trim()
            val password = etPassword.text.toString()
            if (username.isNotEmpty() && password.trim().isNotEmpty())
                viewModel.createManager(username, password)
            else context?.showAlertDialog(
                getString(R.string.alert_dialog_invalid_fields_body)
            )
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.onManagerCreatedSuccessLiveData.observe(viewLifecycleOwner, EventObserver { success ->
            if (success)
                context?.showAlertDialog(
                    getString(R.string.alert_dialog_manager_created_body)
                ) { _, _ -> findNavController().navigateUp() }
            else context?.showAlertDialog(
                getString(R.string.alert_dialog_general_error)
            )
        })
    }

}