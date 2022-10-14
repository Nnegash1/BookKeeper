package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.data.data_source.entities.Client
import com.example.bookkeeper.databinding.FragmentAddClientBinding
import com.example.bookkeeper.presentation.viewmodel.ClientViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceDetailViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentAddClient : Fragment() {

    @Inject
    lateinit var viewModelFactory: InvoiceViewModelFactory

    lateinit var binding: FragmentAddClientBinding
    private val clientVM: ClientViewModel by viewModels { viewModelFactory }
    private val invoiceDetails: InvoiceDetailViewModel by activityViewModels() { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentAddClientBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submit.setOnClickListener {
            val client = addNewClient()
            clientVM.updateState(client)
            navigateToInvoiceDetail()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            clientVM.client.collect {
                it.client?.let { it1 -> invoiceDetails.clientUpdate(it1) }
            }
        }
    }

    private fun addNewClient(): Client {

        val client = with(binding) {
            Client(
                name = clientName.text.toString(),
                phoneNumber = phoneNumber.text.toString(),
                email = email.text.toString(),
                country = country.text.toString(),
                street = street.text.toString(),
                apt = aptSuit.text.toString(),
                postCode = postCode.text.toString(),
                city = city.text.toString(),
                province = state.text.toString()
            )
        }
        return client
    }

    private fun navigateToInvoiceDetail() {
        findNavController().popBackStack()
    }
}