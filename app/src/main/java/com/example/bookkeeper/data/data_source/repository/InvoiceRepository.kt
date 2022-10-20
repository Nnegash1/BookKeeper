package com.example.bookkeeper.data.data_source.repository

import android.util.Log
import com.example.bookkeeper.data.data_source.entities.*
import com.example.bookkeeper.data.data_source.local.InvoiceDAO
import com.example.bookkeeper.domain.repository.InvoiceRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class InvoiceRepository @Inject constructor(private val db: InvoiceDAO) : InvoiceRepository {

    override suspend fun getAllInvoice(): Flow<List<Invoice>> = db.getAllInvoice()

    override suspend fun addInvoice(invoice: Invoice) =
        withContext(Dispatchers.Default) { db.insertAll(invoice) }

    override suspend fun deleteInvoice(invoice: Invoice) = db.delete(invoice)

    override suspend fun filterInvoiceByClientName(client: String): List<Invoice> {
        val result: List<Invoice>
        withContext(Dispatchers.Default) {
            val response = db.getAllInvoice()
            result = response.map { invoiceList ->
                invoiceList.filter {
                    it.client.name == client
                }
            }.first()

            Log.d(
                InvoiceRepository::class.java.simpleName, "filterInvoiceByClientName: ${
                    result.map { list_ ->
                        list_.client.name
                    }
                }"
            )
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

            Log.d(
                InvoiceRepository::class.java.simpleName, "Filter By ref No: ${
                    result.map { list_ ->
                        list_.client.name
                    }
                }"
            )
        }

        return result
    }


}