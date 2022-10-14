package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailPageViewModel @Inject constructor(private val repo : InvoiceRepository) : ViewModel() {

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