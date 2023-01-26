package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.domain.repository.InvoiceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemPageViewModel @Inject constructor(private val repo: InvoiceRepository) : ViewModel() {
    private val _itemState: MutableStateFlow<Item> = MutableStateFlow(Item())
    private val _listOfItemState: MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val itemState get() = _itemState.asStateFlow()
    val listItemState get() = _listOfItemState.asStateFlow()

    fun getAddedItem(item: Item) = viewModelScope.launch {
        _itemState.value = item
    }

    fun getItemFromDb(ref_no: Long) = viewModelScope.launch {
        val invoice = repo.filterByRefNo(ref_no)
        _listOfItemState.value = invoice.let {
            it[0].item
        }
    }

}