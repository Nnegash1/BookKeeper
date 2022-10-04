package com.example.bookkeeper.ui.item_page_viewmodel

import com.example.bookkeeper.model.data.Item

sealed class ItemScreenState {
    class Success(val item:  MutableList<Item>) : ItemScreenState()
    object Empty : ItemScreenState()
}
