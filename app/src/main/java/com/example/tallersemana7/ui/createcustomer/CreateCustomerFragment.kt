package com.example.tallersemana7.ui.createcustomer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.tallersemana7.R
import com.example.tallersemana7.databinding.FragmentCreateCustomerBinding

class CreateCustomerFragment : Fragment() {

    private var _binding: FragmentCreateCustomerBinding? = null
    private val binding get() = _binding!!

    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etIdentification: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText

    private lateinit var btCreateCustomer: Button

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
        btCreateCustomer.setOnClickListener {  }
    }

}