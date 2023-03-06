package com.example.tallersemana7.ui.createmanager

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.tallersemana7.R

class CreateManagerFragment : Fragment() {

    private lateinit var btCreateManager: Button
    private lateinit var etName: EditText
    private lateinit var etPassword: EditText

    companion object {
        fun newInstance() = CreateManagerFragment()
    }

    private lateinit var viewModel: CreateManagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateManagerViewModel::class.java)
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
            val password =  etPassword.text.toString()
            if (username.isNotEmpty() &&
                password.trim().isNotEmpty())
                viewModel.createManager(username, password)
            else {}
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel

    }

}