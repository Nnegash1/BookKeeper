package com.example.bookkeeper.domain.repository

import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.InvoiceData
import kotlinx.coroutines.flow.Flow

interface InvoiceRepository {
    suspend fun addInvoice(invoice: Invoice)
    suspend fun getAllInvoice(): Flow<List<Invoice>>
    suspend fun deleteInvoice(invoice: Invoice)
}