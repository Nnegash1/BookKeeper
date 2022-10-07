package com.example.bookkeeper.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.presentation.viewmodel.state.DetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailPageViewModel : ViewModel() {

    private val _detail: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    private val _checked: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val detail get() = _detail.asStateFlow()
    val checked get() = _checked.asStateFlow()

    fun updateDetail(detail_: InvoiceDetails) = viewModelScope.launch {
        _detail.value = DetailState(detail_)
    }

    fun isChecked(boolean: Boolean) {
        _checked.value = boolean
    }

}