package com.example.bookkeeper.model

import com.example.bookkeeper.model.data.Invoice
import com.example.bookkeeper.model.data.InvoiceData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object InvoiceRepository {
    suspend fun getAllInvoice(): InvoiceData {
        return mock_data
    }

    fun addInvoice(invoice: Invoice) {
        mock_data.invoiceData.add(invoice)
    }
}