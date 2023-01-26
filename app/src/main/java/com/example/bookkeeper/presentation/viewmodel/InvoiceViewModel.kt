package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


class InvoiceViewModel @Inject constructor(private val repo: InvoiceRepository) : ViewModel() {
    private val _invoiceScreenUIState: MutableStateFlow<InvoiceScreenUIState> = MutableStateFlow(InvoiceScreenUIState.Empty)
    val uiState get() = _invoiceScreenUIState.asStateFlow()

    fun getAllInvoice() = viewModelScope.launch {
        val response = repo.getAllInvoice().first()
        _invoiceScreenUIState.value = InvoiceScreenUIState.Success(response)
    }

    fun filterInvoiceByClientName(client: String) = viewModelScope.launch {
        val response = repo.filterInvoiceByClientName(client)
        _invoiceScreenUIState.value = InvoiceScreenUIState.Success(response)
    }
}