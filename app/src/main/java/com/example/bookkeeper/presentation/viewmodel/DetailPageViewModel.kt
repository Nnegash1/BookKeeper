package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.presentation.viewmodel.state.DetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailPageViewModel : ViewModel() {

    private val _detail: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    val detail get() = _detail.asStateFlow()

    fun updateDetail(detail_: InvoiceDetails) = viewModelScope.launch {
        _detail.value = DetailState(detail_)
    }
}