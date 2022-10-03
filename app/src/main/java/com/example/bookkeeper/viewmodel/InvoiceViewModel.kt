package com.example.bookkeeper.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.model.InvoiceRepository
import com.example.bookkeeper.model.data.Invoice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InvoiceViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Empty)
    val uiState get() = _uiState.asStateFlow()

    fun getAllInvoice() = viewModelScope.launch {
        val response = InvoiceRepository.getAllInvoice()
        _uiState.value = UIState.Success(response)
        Log.d("TAG", "getAllInvoice: ${response.invoiceData[0].address}")
    }

    fun addInvoice(invoice: Invoice) = viewModelScope.launch {
        InvoiceRepository.addInvoice(invoice)
    }

}