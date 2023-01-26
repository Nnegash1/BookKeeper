package com.example.bookkeeper.data.data_source.repository

import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.local.InvoiceDAO
import com.example.bookkeeper.domain.repository.InvoiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InvoiceRepository @Inject constructor(private val db: InvoiceDAO) : InvoiceRepository {

    override suspend fun getAllInvoice(): Flow<List<Invoice>> =
        withContext(Dispatchers.Default) { db.getAllInvoice() }

    override suspend fun addInvoice(invoice: Invoice) =
        withContext(Dispatchers.Default) { db.insertAll(invoice) }

    override suspend fun deleteInvoice(invoice: Invoice) =
        withContext(Dispatchers.Default) { db.delete(invoice) }

    override suspend fun filterInvoiceByClientName(client: String): List<Invoice> {
        val result: List<Invoice>
        withContext(Dispatchers.Default) {
            val response = db.getAllInvoice()
            result = response.map { invoiceList ->
                invoiceList.filter {
                    it.client.name == client
                }
            }.first()
        }
        return result
    }

    override suspend fun filterByRefNo(ref_no: Long): List<Invoice> {
        val result: List<Invoice>
        withContext(Dispatchers.Default) {
            val response = db.getAllInvoice()
            result = response.map { invoiceList ->
                invoiceList.filter {
                    it.invoiceDetails.referenceNo == ref_no
                }
            }.first()
        }
        return result
    }
}