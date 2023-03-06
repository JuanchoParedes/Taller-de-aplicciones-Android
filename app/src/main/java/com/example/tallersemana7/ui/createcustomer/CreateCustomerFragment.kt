package com.example.tallersemana7.ui.createcustomer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tallersemana7.R
import com.example.tallersemana7.databinding.FragmentCreateCustomerBinding
import com.example.tallersemana7.di.ComponentProvider
import com.example.tallersemana7.ui.customersbymanager.CustomersByManagerViewModel
import com.example.tallersemana7.ui.showAlertDialog
import javax.inject.Inject

class CreateCustomerFragment : Fragment() {

    private var _binding: FragmentCreateCustomerBinding? = null
    private val binding get() = _binding!!

    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etIdentification: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText

    private lateinit var btCreateCustomer: Button

    @Inject
    lateinit var factory: CreateCustomerViewModelFactory
    private lateinit var viewModel: CreateCustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = (activity?.application as ComponentProvider).getComponent()
        component.inject(this)

        viewModel = ViewModelProvider(this, factory)[CreateCustomerViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateCustomerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        etName = binding.etName
        etLastName = binding.etLastName
        etIdentification = binding.etIdentification
        etPhone = binding.etPhone
        etEmail = binding.etEmail
        btCreateCustomer = binding.btCreateCustomer

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btCreateCustomer.setOnClickListener {
            val name = etName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val identification = etIdentification.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val email = etEmail.text.toString().trim()
            if (name.isEmpty() || lastName.isEmpty() || identification.isEmpty()
                || phone.isEmpty() || email.isEmpty()
            )
                context?.showAlertDialog(
                    getString(R.string.alert_dialog_invalid_fields_body)
                )
            else viewModel.createCustomer(
                name, lastName, identification, email, phone
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.onCustomerCreatedSuccessLiveData.observe(viewLifecycleOwner) { success ->
            if (success) {
                context?.showAlertDialog(
                    getString(R.string.alert_dialog_customer_created_body)
                )
                etName.setText("")
                etLastName.setText("")
                etIdentification.setText("")
                etPhone.setText("")
                etEmail.setText("")
            } else
                context?.showAlertDialog(
                    getString(R.string.alert_dialog_general_error)
                )
        }
    }

}