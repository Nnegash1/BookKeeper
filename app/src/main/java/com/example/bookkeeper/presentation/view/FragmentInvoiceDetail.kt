package com.example.bookkeeper.presentation.view

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
import com.example.bookkeeper.presentation.view.adapter.ItemAdapter
import com.example.bookkeeper.presentation.viewmodel.InvoiceDetailViewModel

class FragmentInvoiceDetail : Fragment() {

    private lateinit var binding: FragmentInvoiceDetailBinding
    private val itemAdapter = ItemAdapter()
    private val invoiceVM: InvoiceDetailViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentInvoiceDetailBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            invoiceVM.item.collect {
                itemAdapter.update(it.item)
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            invoiceVM.client.collect {
                binding.clientName.text = it.client?.name
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            invoiceVM.invoiceDetail.collect {
                binding.detail.text = it.invoice.invoiceNumber
            }
        }

        binding.saveInvoiceBtn.setOnClickListener {
            invoiceVM.addInvoice()
            invoiceVM.clear()
        }

        callTrace()
    }

    private fun initAdapter() {
        with(binding) {
            itemRecycler.layoutManager = LinearLayoutManager(requireActivity())
            itemRecycler.adapter = itemAdapter
        }
    }

    private fun navigateToItemPage() {
        binding.addItemButton.setOnClickListener {
            val action =
                FragmentInvoiceDetailDirections.actionFragmentInvoiceDetail3ToFragmentItemPage()
            findNavController().navigate(action)
        }
    }

    private fun navigateToClientPage() {
        binding.clientCard.setOnClickListener {
            val action =
                FragmentInvoiceDetailDirections.actionFragmentInvoiceDetail3ToFragmentAddClient()
            findNavController().navigate(action)
        }
    }

    private fun navigateToDetailPage() {
        binding.detail.setOnClickListener {
            val action =
                FragmentInvoiceDetailDirections.actionFragmentInvoiceDetail3ToFragmentDetail()
            findNavController().navigate(action)
        }
    }

    private fun callTrace() {
        initAdapter()
        navigateToDetailPage()
        navigateToItemPage()
        navigateToClientPage()
    }
}
