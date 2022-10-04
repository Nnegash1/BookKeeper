package com.example.bookkeeper.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookkeeper.databinding.FragmentInvoiceDetailBinding
import com.example.bookkeeper.ui.adapter.ItemAdapter
import com.example.bookkeeper.ui.item_page_viewmodel.ItemPageViewModel
import com.example.bookkeeper.ui.item_page_viewmodel.ItemScreenState

class FragmentInvoiceDetail : Fragment() {

    private lateinit var binding: FragmentInvoiceDetailBinding
    private val itemVm: ItemPageViewModel by activityViewModels()
    private val itemAdapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentInvoiceDetailBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemVm.itemState.collect {
                if (it is ItemScreenState.Success) {
                    itemAdapter.update(it.item)
                }
            }
        }
        navigateToItemPage()
        navigateToClientPage()
        initAdapter()
        itemVm.getAddedItem()
    }

    private fun initAdapter() {
        with(binding) {
            itemRecycler.layoutManager = LinearLayoutManager(requireActivity())
            itemRecycler.adapter = itemAdapter
        }
    }

    private fun navigateToItemPage() {
        binding.detailCard.setOnClickListener {
            val action = FragmentInvoiceDetailDirections.actionFragmentInsertItemToFragmentAddItem()
            findNavController().navigate(action)
        }
    }


    private fun navigateToClientPage() {
        binding.clientCard.setOnClickListener {
            val action =
                FragmentInvoiceDetailDirections.actionFragmentInsertItemToFragmentAddClient()
            findNavController().navigate(action)
        }
    }
}
