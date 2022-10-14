package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.databinding.FragmentAlertDialogBinding
import com.example.bookkeeper.databinding.FragmentHomePageBinding
import com.example.bookkeeper.presentation.view.adapter.InvoiceAdapter
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.presentation.viewmodel.state.UIState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class HomePageFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: InvoiceViewModelFactory
    private lateinit var binding: FragmentHomePageBinding
    private val vm: InvoiceViewModel by viewModels { viewModelFactory }
    private val adapter = InvoiceAdapter { selectedInvoice ->
        selectedInvoice(selectedInvoice)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentHomePageBinding.inflate(layoutInflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            vm.uiState.collect {
                if (it is UIState.Success) {
                    adapter.update(it.data)
                }
            }
        }

        binding.fab.setOnClickListener {
            val action =
                HomePageFragmentDirections.actionHomePageFragment2ToFragmentInvoiceDetail3()
            findNavController().navigate(action)
        }

        initAdapter()
        vm.getAllInvoice()

    }

    private fun initAdapter() {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireActivity())
            recyclerView.adapter = adapter
        }
    }

    private fun selectedInvoice(invoice: Invoice): Invoice {
        Toast.makeText(context, invoice.client.name, Toast.LENGTH_SHORT).show()
        vm.deleteInvoice(invoice)
//        val action = HomePageFragmentDirections.actionHomePageFragment2ToClientInformation()
//        findNavController().navigate(action)
        return invoice
    }
}