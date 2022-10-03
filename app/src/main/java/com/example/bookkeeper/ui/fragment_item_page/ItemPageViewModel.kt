package com.example.bookkeeper.ui.fragment_item_page

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

    fun getAddedItem(item: Item) = viewModelScope.launch {
        _itemState.value = ItemScreenState.Success(item)
    }
}