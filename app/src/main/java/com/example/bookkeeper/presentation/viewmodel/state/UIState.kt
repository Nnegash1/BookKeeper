package com.example.bookkeeper.presentation.viewmodel.state

import com.example.bookkeeper.data.data_source.entities.InvoiceData

sealed class UIState {
    class Success(val data: InvoiceData) : UIState()
    object Empty : UIState()
}
