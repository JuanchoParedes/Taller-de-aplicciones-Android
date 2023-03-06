package com.example.tallersemana7.ui.customersbymanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tallersemana7.R

class CustomerDetailsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.item_view_customers, parent, false)
) {
    private var tvName: TextView = itemView.findViewById(R.id.tvName)
    private val tvLastname: TextView = itemView.findViewById(R.id.tvLastname)
    private val tvIdentification: TextView = itemView.findViewById(R.id.tvIdentification)
    private val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
    private val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)

    fun bind(item: CustomerAdapterItem, listener: OnCustomerClickListener<CustomerAdapterItem>?) {
        with(item) {
            tvName.text = name
            tvLastname.text = lastName
            tvIdentification.text = identification
            tvPhone.text = phone
            tvEmail.text = email
        }
        itemView.setOnClickListener { listener?.invoke(item) }
    }
}