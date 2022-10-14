package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.domain.repository.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemPageViewModel @Inject constructor(private val repo : InvoiceRepository) : ViewModel() {
    private val _itemState: MutableStateFlow<Item> = MutableStateFlow(Item())
    val itemState get() = _itemState.asStateFlow()


    fun getAddedItem(item: Item) = viewModelScope.launch {
        _itemState.value = item
    }

}