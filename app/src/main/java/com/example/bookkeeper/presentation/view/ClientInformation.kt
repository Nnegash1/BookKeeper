package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.databinding.FragmentClientInformationBinding
import com.example.bookkeeper.presentation.viewmodel.ClientInformationViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceScreenUIState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ClientInformation : Fragment() {

    @Inject
    lateinit var factory: InvoiceViewModelFactory
    lateinit var binding: FragmentClientInformationBinding
    private val vm: ClientInformationViewModel by activityViewModels() { factory }
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

        binding.purchasedItemBtn?.setOnClickListener {
            vm.clientInfoState.value.let {
                if (it is InvoiceScreenUIState.Success) {
                    val action =
                        ClientInformationDirections.actionClientInformationToItemRecyclerView(it.data[0].invoiceDetails.referenceNo)
                    findNavController().navigate(action)
                }
            }

        }
        binding.preview.setOnClickListener {

            val action = ClientInformationDirections.actionClientInformationToPreviewPage()
            findNavController().navigate(action)
        }

        binding.delete.setOnClickListener {
            val invoice = vm.clientInfoState.value
            if (invoice is InvoiceScreenUIState.Success) {
                val dialog = FragmentAlertDialog(invoice.data[0])
                dialog.show(parentFragmentManager, "custom_dialog")
            }
        }
        vm.filterInvoiceByReferenceNo(arg.invoiceNumber)
    }

    private fun initClientInformation(invoice: List<Invoice>) {

        invoice.map { it ->
            var balance = 0.00
            val price = it.item.map { it.unit_price * it.qty }
            if (price.isNotEmpty()) {
                balance = price.reduce { acc, d -> acc + d }
            }
            val totalPrice = balance - it.invoiceDetails.discount

            with(binding) {
                clientName.text = it.client.name
                clientEmail.text = it.client.email
                issueDate.text = it.invoiceDetails.issueDate
                subTitle.text = it.invoiceDetails.invoiceNumber
                phoneNumber.text = it.client.phoneNumber
                dueDate.text = it.invoiceDetails.dueDate
                reference?.text = it.invoiceDetails.referenceNo.toString()
                discount.text = it.invoiceDetails.discount.toString()
                balanceDue.text = balance.toString()
                total?.text = totalPrice.toString()
                discount.text = it.invoiceDetails.discount.toString()
            }
        }

    }
}