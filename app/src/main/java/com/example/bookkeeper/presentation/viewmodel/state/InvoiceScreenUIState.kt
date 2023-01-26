package com.example.bookkeeper.presentation.viewmodel.state

import com.example.bookkeeper.data.data_source.entities.Invoice

sealed class InvoiceScreenUIState {
    class Success(val data: List<Invoice>) : InvoiceScreenUIState()
    object Empty : InvoiceScreenUIState()
}
