package com.example.bookkeeper.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookkeeper.R
import com.example.bookkeeper.databinding.InvoiceCardBinding
import com.example.bookkeeper.databinding.ItemCardBinding
import com.example.bookkeeper.model.data.Item

class ItemAdapter : RecyclerView.Adapter<ItemCardHolder>() {
    private val itemData: MutableList<Item> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardHolder {
        return ItemCardHolder(
            ItemCardBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ItemCardHolder, position: Int) {
        holder.display(itemData[position])
    }

    override fun getItemCount() = itemData.size

    fun update(newItem: List<Item>) {
        val oldSize = itemData.size
        notifyItemRangeChanged(0, oldSize)
        itemData.clear()
        itemData.addAll(newItem)
        notifyItemRangeChanged(0, newItem.size)
    }
}

class ItemCardHolder(private val binding: ItemCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun display(card: Item) {
        binding.client.text = card.brand
        val total = card.unit_price * card.qty
        binding.price.text = "$total $"
    }
}