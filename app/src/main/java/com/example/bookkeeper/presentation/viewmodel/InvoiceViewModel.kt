package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InvoiceViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Empty)
    val uiState get() = _uiState.asStateFlow()

    fun getAllInvoice() = viewModelScope.launch {
        val response = InvoiceRepository.getAllInvoice()
        _uiState.value = UIState.Success(response)
    }
}