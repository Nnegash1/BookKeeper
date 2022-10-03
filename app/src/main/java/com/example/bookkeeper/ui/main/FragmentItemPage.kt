package com.example.bookkeeper.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bookkeeper.databinding.FragmentAddItemBinding
import com.example.bookkeeper.model.data.Item
import com.example.bookkeeper.ui.fragment_item_page.ItemPageViewModel

class FragmentItemPage : Fragment() {

    lateinit var binding: FragmentAddItemBinding
    private val itemPageViewModel: ItemPageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentAddItemBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submit.setOnClickListener {
            val result = getUserInput()
            itemPageViewModel.getAddedItem(result)
        }
    }

    private fun getUserInput(): Item {
        val result = with(binding) {
            Item(
                description = description.text.toString(),
                brand = brand.text.toString(),
                origin = origin.text.toString(),
                hs_code = hsCode.text.toString(),
                item = item.text.toString(),
                qty = qty.text.toString().toDouble(),
                unit_price = unitPrice.text.toString().toDouble(),
                discount = 0.0,
                fob_price = 0.0
            )
        }
        return result
    }

}