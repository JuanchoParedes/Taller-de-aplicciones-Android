package com.example.tallersemana7.ui.customersbymanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.tallersemana7.R
import com.example.tallersemana7.di.ComponentProvider
import com.example.tallersemana7.ui.customersbymanager.adapter.CustomerDetailsAdapter
import javax.inject.Inject

class CustomersByManagerFragment: Fragment() {

    @Inject
    lateinit var factory: CustomersByManagerViewModelFactory
    private lateinit var viewModel: CustomersByManagerViewModel

    private val customerDetailsAdapter = CustomerDetailsAdapter()
    private lateinit var rvCustomersByManager: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = (activity?.application as ComponentProvider).getComponent()
        component.inject(this)

        viewModel = ViewModelProvider(this, factory)[CustomersByManagerViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_customers_by_manager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCustomersByManager = view.findViewById(R.id.rvCustomersByManager)
        rvCustomersByManager.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = customerDetailsAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.customersByManagerLiveData.observe(viewLifecycleOwner) {
            customerDetailsAdapter.submitList(it)
        }

    }
}