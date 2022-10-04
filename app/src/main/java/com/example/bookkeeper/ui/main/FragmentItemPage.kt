package com.example.bookkeeper.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.databinding.FragmentAddItemBinding
import com.example.bookkeeper.model.data.Item
import com.example.bookkeeper.ui.item_page_viewmodel.ItemPageViewModel
import java.lang.NumberFormatException

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
            if (result is Item) {
                itemPageViewModel.addItem(result)
                findNavController().popBackStack()
            }
        }
    }

    private fun getUserInput(): Any {
        val result = try {
            var discount = binding.discount.text.toString()
            if (discount == "") {
                discount = "0"
            }
            with(binding) {
                Item(
                    description = description.text.toString(),
                    brand = brand.text.toString(),
                    origin = origin.text.toString(),
                    hs_code = hsCode.text.toString(),
                    item = item.text.toString(),
                    qty = qty.text.toString().toDouble(),
                    unit_price = unitPrice.text.toString().toDouble(),
                    discount = discount.toDouble(),
                    fob_price = 0.0
                )
            }
        } catch (message: NumberFormatException) {
            Toast.makeText(requireContext(), "Fill all the space ", Toast.LENGTH_LONG).show()
        }
        return result
    }

}