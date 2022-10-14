package com.example.bookkeeper.presentation.viewmodel.state

import com.example.bookkeeper.data.data_source.entities.Invoice

sealed class UIState {
    class Success(val data: List<Invoice>) : UIState()
    object Empty : UIState()
}
