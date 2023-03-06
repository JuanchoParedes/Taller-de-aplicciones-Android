package com.example.tallersemana7.ui.customersbymanager.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CustomerDetailsAdapter: ListAdapter<CustomerAdapterItem, CustomerDetailsViewHolder>(
    ListAdapterItemsInvalidatorDiffCallback<CustomerAdapterItem>()
) {
    val onCustomerClickListener: OnCustomerClickListener<CustomerAdapterItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CustomerDetailsViewHolder(parent)

    override fun onBindViewHolder(holder: CustomerDetailsViewHolder, position: Int) {
        holder.bind(getItem(position), onCustomerClickListener)
    }
}

typealias OnCustomerClickListener <T> = (T) -> Unit

class ListAdapterItemsInvalidatorDiffCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }
}