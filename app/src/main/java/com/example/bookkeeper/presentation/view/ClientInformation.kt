package com.example.bookkeeper.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.bookkeeper.R
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.databinding.FragmentClientInformationBinding
import com.example.bookkeeper.presentation.viewmodel.ClientInformationViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceDetailViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceScreenUIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class ClientInformation : Fragment() {

    @Inject
    lateinit var factory: InvoiceViewModelFactory
    lateinit var binding: FragmentClientInformationBinding
    private val vm: ClientInformationViewModel by viewModels() { factory }
    private val arg by navArgs<ClientInformationArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentClientInformationBinding.inflate(layoutInflater, container, false)
        .also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            vm.clientInfoState.collect {
                if (it is InvoiceScreenUIState.Success) {
                    initClientInformation(it.data)
                }
            }
        }
        vm.filterInvoiceByReferenceNo(arg.invoiceNumber)
    }

    private fun initClientInformation(invoice: List<Invoice>) {
        invoice.map {
            with(binding) {
                clientName.text = it.client.name
                clientEmail.text = it.client.email
                issueDate.text = it.invoiceDetails.issueDate
                invoiceNumber.text = it.invoiceDetails.invoiceNumber
                referenceNumber.text = it.invoiceDetails.referenceNo.toString()
                balanceDue.text = it.item?.map {
                    it.unit_price
                }.toString()
                discount.text = it.invoiceDetails.discount.toString()
            }
        }

    }
}