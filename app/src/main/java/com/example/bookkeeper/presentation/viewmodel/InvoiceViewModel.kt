package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InvoiceViewModel @Inject constructor(private val repo: InvoiceRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Empty)
    val uiState get() = _uiState.asStateFlow()

    fun getAllInvoice() = viewModelScope.launch {
        val response = repo.getAllInvoice().first()
        _uiState.value = UIState.Success(response)
    }

    fun deleteInvoice(invoice: Invoice) = viewModelScope.launch {
        withContext(Dispatchers.Default) {
            repo.deleteInvoice(invoice)
            update()
        }
        delay(2_000L)
    }

    private fun update() = viewModelScope.launch {
        val response = repo.getAllInvoice().first()
        _uiState.value = UIState.Success(response)
    }
}