package com.example.bookkeeper.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.databinding.FragmentClientDetailBinding
import com.example.bookkeeper.ui.fragment_item_page.ItemPageViewModel
import com.example.bookkeeper.ui.fragment_item_page.ItemScreenState
import com.example.bookkeeper.viewmodel.InvoiceViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest


class FragmentInvoiceDetail : Fragment() {

    lateinit var binding: FragmentClientDetailBinding
    private val itemVm: ItemPageViewModel by activityViewModels()
    private val vm: InvoiceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentClientDetailBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemVm.itemState.collect {
                if (it is ItemScreenState.Success) {
                    Log.d("TAG", "onViewCreated: ${it.item}")
                }
            }
        }

        binding.item.setOnClickListener {
            val action = FragmentInvoiceDetailDirections.actionFragmentInsertItemToFragmentAddItem()
            findNavController().navigate(action)
        }
    }
}
