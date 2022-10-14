package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.databinding.FragmentAddItemBinding
import com.example.bookkeeper.presentation.viewmodel.InvoiceDetailViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.presentation.viewmodel.ItemPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentItemPage : Fragment() {

    @Inject
    lateinit var viewModelFactory: InvoiceViewModelFactory
    private lateinit var binding: FragmentAddItemBinding
    private val itemPageViewModel: ItemPageViewModel by viewModels { viewModelFactory }
    private val invoiceVm: InvoiceDetailViewModel by activityViewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentAddItemBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemPageViewModel.itemState.collect {
                updateUI(it)
            }
        }

        binding.submit.setOnClickListener {
            val result = getUserInput()
            if (result is Item) {
                invoiceVm.addItem(result)
                itemPageViewModel.getAddedItem(result)
                findNavController().popBackStack()
            }
        }
    }

    private fun getUserInput(): Any {
        val result = try {
            with(binding) {
                Item(
                    description = description.text.toString(),
                    brand = brand.text.toString(),
                    origin = origin.text.toString(),
                    hs_code = hsCode.text.toString(),
                    item = item.text.toString(),
                    qty = qty.text.toString().toInt(),
                    unit_price = unitPrice.text.toString().toDouble(),
                    fob_price = 0.0
                )
            }
        } catch (message: NumberFormatException) {
            Toast.makeText(requireContext(), "Fill all the space ", Toast.LENGTH_LONG).show()
        }
        return result
    }

    private fun updateUI(item: Item) {
        with(binding) {
            description.setText(item.description)
            brand.setText(item.brand)
            origin.setText(item.origin)
            hsCode.setText(item.hs_code)
            this.item.setText(item.item)
            qty.setText(item.qty.toString())
            unitPrice.setText(item.unit_price.toString())
        }
    }

}