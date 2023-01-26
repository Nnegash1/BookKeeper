package com.example.bookkeeper.presentation.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.databinding.ItemCardBinding
import com.example.bookkeeper.data.data_source.entities.Item

class ItemAdapter() : RecyclerView.Adapter<ItemCardHolder>() {
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
        binding.quantity.text = "qty :${card.qty}"
        binding.unitPrice.text = "unit: ${card.unit_price}"
        val total = card.unit_price * card.qty
        binding.price.text = "$total $"
    }
}