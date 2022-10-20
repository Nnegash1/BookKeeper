package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.databinding.FragmentAlertDialogBinding
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
class FragmentAlertDialog(val invoice: Invoice) : DialogFragment() {
    lateinit var binding: FragmentAlertDialogBinding

    @Inject
    lateinit var vmFactory: InvoiceViewModelFactory
    private val invoiceVM: InvoiceViewModel by activityViewModels { vmFactory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        invoiceVM.getAllInvoice()
        return FragmentAlertDialogBinding.inflate(layoutInflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.delete.setOnClickListener {
            invoiceVM.deleteInvoice(invoice = invoice)
            dismiss()
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

}