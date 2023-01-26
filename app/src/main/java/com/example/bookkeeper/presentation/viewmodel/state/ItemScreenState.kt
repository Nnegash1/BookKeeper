package com.example.bookkeeper.presentation.viewmodel.state

import com.example.bookkeeper.data.data_source.entities.Item

data class ItemScreenState(val item: MutableList<Item> = mutableListOf())