package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.databinding.FragmentPreviewPageBinding
import com.example.bookkeeper.presentation.view.adapter.ItemAdapter
import com.example.bookkeeper.presentation.viewmodel.ClientInformationViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceScreenUIState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class PreviewPage : Fragment() {

    lateinit var binding: FragmentPreviewPageBinding
    private val adapter = ItemAdapter()

    @Inject
    lateinit var factory: InvoiceViewModelFactory
    private val vm: ClientInformationViewModel by activityViewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentPreviewPageBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.fab.setOnClickListener {
        val pdfDetails = vm.clientInfoState.value
        if (pdfDetails is InvoiceScreenUIState.Success) {
            bindingPreview(pdfDetails.data[0])
            adapter.update(pdfDetails.data[0].item)
//                val pdfConverter = PDFConverter()
//                pdfConverter.createPdf(requireContext(), pdfDetails.data[0], requireActivity())
        }
//        }
    }

    private fun bindingPreview(invoice: Invoice) {
        with(binding) {
            clientName.text = invoice.client.name
            clientEmailStatic.text = invoice.client.email
            clientPhoneNumber.text = invoice.client.phoneNumber
            clientAddress.text = invoice.client.street
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}