package com.example.bookkeeper.viewmodel

import com.example.bookkeeper.model.data.InvoiceData

sealed class UIState {
    class Success(val data: InvoiceData) : UIState()
    object Empty : UIState()
}
