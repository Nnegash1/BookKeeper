package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClientInformationViewModel(private val repo: InvoiceRepository) : ViewModel() {
    private val _clientInfoState: MutableStateFlow<InvoiceScreenUIState> =
        MutableStateFlow(InvoiceScreenUIState.Empty)
    val clientInfoState get() = _clientInfoState.asStateFlow()

    fun filterInvoiceByReferenceNo(ref_no: Long) = viewModelScope.launch {
        val response = repo.filterByRefNo(ref_no)
        _clientInfoState.value = InvoiceScreenUIState.Success(response)
    }
}