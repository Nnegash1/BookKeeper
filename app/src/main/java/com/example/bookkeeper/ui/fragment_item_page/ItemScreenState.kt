package com.example.bookkeeper.ui.fragment_item_page

import com.example.bookkeeper.model.data.Item

sealed class ItemScreenState {
    class Success(val item: Item) : ItemScreenState()
    object Empty : ItemScreenState()
}
