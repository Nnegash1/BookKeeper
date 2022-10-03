package com.example.bookkeeper.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookkeeper.databinding.InvoiceCardBinding
import com.example.bookkeeper.model.data.Invoice

class InvoiceAdapter : RecyclerView.Adapter<InvoiceCardViewHolder>() {
    private val invoiceList: MutableList<Invoice> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceCardViewHolder {
        return InvoiceCardViewHolder(
            InvoiceCardBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: InvoiceCardViewHolder, position: Int) {
        holder.display(invoiceList[position])
    }

    override fun getItemCount() = invoiceList.size

    fun update(newList: List<Invoice>) {
        val oldSize = invoiceList.size
        invoiceList.clear()
        notifyItemRangeChanged(0, oldSize)
        invoiceList.addAll(newList)
        notifyItemRangeChanged(0, newList.size)
    }
}

class InvoiceCardViewHolder(private val binding: InvoiceCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun display(card: Invoice) {
        with(binding) {
            client.text = card.client
            invoiceNumber.text = card.invoice_id.toString()
        }
    }

}
