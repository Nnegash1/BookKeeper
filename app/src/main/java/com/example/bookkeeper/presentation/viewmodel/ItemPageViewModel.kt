package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemPageViewModel : ViewModel() {
    private val _itemState: MutableStateFlow<Item> = MutableStateFlow(Item())
    val itemState get() = _itemState.asStateFlow()


    fun getAddedItem(item: Item) = viewModelScope.launch {
        _itemState.value = item
    }

}