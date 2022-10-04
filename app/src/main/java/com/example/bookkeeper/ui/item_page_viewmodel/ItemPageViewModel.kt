package com.example.bookkeeper.ui.item_page_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.model.data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemPageViewModel : ViewModel() {
    private val _itemState: MutableStateFlow<ItemScreenState> =
        MutableStateFlow(ItemScreenState.Empty)
    val itemState get() = _itemState.asStateFlow()
    private val itemContainer: MutableList<Item> = mutableListOf()

    fun getAddedItem() = viewModelScope.launch {
        _itemState.value = ItemScreenState.Success(itemContainer)
    }

    fun addItem(item: Item) {
        itemContainer.add(item)
    }
}