package com.example.bookkeeper.presentation.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.databinding.InvoiceCardBinding

class InvoiceAdapter(private val selectedInvoice: (Invoice) -> Unit) :
    RecyclerView.Adapter<InvoiceCardViewHolder>() {
    private val invoiceList: MutableList<Invoice> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceCardViewHolder {
        return InvoiceCardViewHolder(
            InvoiceCardBinding.inflate(LayoutInflater.from(parent.context)),
            selectedInvoice
        )
    }

    override fun onBindViewHolder(holder: InvoiceCardViewHolder, position: Int) {
        holder.itemView.setOnClickListener { v ->
            v.setOnClickListener {
                holder.listener(invoiceList[position])
            }

        }
        holder.display(invoiceList[position])
    }

    override fun getItemCount() = invoiceList.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<Invoice>) {
        val oldSize = invoiceList.size
        invoiceList.clear()
        notifyDataSetChanged()
        invoiceList.addAll(newList)
        notifyItemRangeChanged(0, newList.size)
    }
}

class InvoiceCardViewHolder(
    private val binding: InvoiceCardBinding,
    val listener: (Invoice) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun display(card: Invoice) {
        with(binding) {
            client.text = card.client.name
            invoiceNumber.text = card.invoiceDetails.referenceNo.toString()
            dueDate.text = card.invoiceDetails.issueDate
            card.item?.forEach { item ->
                Log.d("TAG", "display: ${item.unit_price}")
            }.toString()
        }
    }
}
