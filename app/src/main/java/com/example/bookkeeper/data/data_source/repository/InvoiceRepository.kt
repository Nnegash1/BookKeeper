package com.example.bookkeeper.data.data_source.repository

import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.InvoiceData
import com.example.bookkeeper.data.data_source.local.mock_data

object InvoiceRepository {
    suspend fun getAllInvoice(): InvoiceData {
        return mock_data
    }

    fun addInvoice(invoice: Invoice) {
        mock_data.invoiceData.add(invoice)
    }
}