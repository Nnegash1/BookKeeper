package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClientInformationViewModel(private val repo: InvoiceRepository) : ViewModel() {
    private val _clientInfoState: MutableStateFlow<InvoiceScreenUIState> =
        MutableStateFlow(InvoiceScreenUIState.Empty)
    val clientInfoState get() = _clientInfoState.asStateFlow()

    fun filterInvoiceByReferenceNo(ref_no: Long) = viewModelScope.launch {
        val response = repo.filterByRefNo(ref_no)
        _clientInfoState.value = InvoiceScreenUIState.Success(response)
    }

    fun deleteInvoice(invoice: Invoice) = viewModelScope.launch {
        withContext(Dispatchers.Default) {
            repo.deleteInvoice(invoice)
        }
        delay(2_000L)
    }
}