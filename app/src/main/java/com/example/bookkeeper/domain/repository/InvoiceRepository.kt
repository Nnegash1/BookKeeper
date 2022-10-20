package com.example.bookkeeper.domain.repository

import com.example.bookkeeper.data.data_source.entities.Client
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.Item
import kotlinx.coroutines.flow.Flow

interface InvoiceRepository {
    suspend fun addInvoice(invoice: Invoice)
    suspend fun getAllInvoice(): Flow<List<Invoice>>
    suspend fun deleteInvoice(invoice: Invoice)
    suspend fun filterInvoiceByClientName(client: String): List<Invoice>
    suspend fun filterByRefNo(ref_no: Long): List<Invoice>
}