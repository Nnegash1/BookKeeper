package com.example.bookkeeper.data.data_source.repository

import android.util.Log
import com.example.bookkeeper.data.data_source.entities.*
import com.example.bookkeeper.data.data_source.local.InvoiceDAO
import com.example.bookkeeper.data.data_source.local.mock_data
import com.example.bookkeeper.domain.repository.InvoiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InvoiceRepository @Inject constructor(private val db: InvoiceDAO) : InvoiceRepository {

    override suspend fun getAllInvoice(): Flow<List<Invoice>> {
        return db.getAllInvoice()
    }

    override suspend fun addInvoice(invoice: Invoice) {
        withContext(Dispatchers.Default) {
            db.insertAll(invoice)
        }
        Log.d("TAG", "addInvoice: ${db.getAllInvoice()}")
        mock_data.invoiceData.add(invoice)
    }

    override suspend fun deleteInvoice(invoice: Invoice) = db.delete(invoice)
}