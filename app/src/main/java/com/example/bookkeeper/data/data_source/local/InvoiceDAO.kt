package com.example.bookkeeper.data.data_source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.InvoiceData
import kotlinx.coroutines.flow.Flow


@Dao
interface InvoiceDAO {
    @Insert
    suspend fun insertAll(vararg users: Invoice)

    @Delete
    fun delete(invoice: Invoice)

    @Query("Select * From Invoice")
    fun getAllInvoice(): Flow<List<Invoice>>
}
