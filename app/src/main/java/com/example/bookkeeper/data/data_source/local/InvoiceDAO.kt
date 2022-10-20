package com.example.bookkeeper.data.data_source.local

import androidx.room.*
import com.example.bookkeeper.data.data_source.entities.*
import kotlinx.coroutines.flow.Flow


@Dao
interface InvoiceDAO {
    @Insert
    suspend fun insertAll(vararg users: Invoice)

    @Delete
    suspend fun delete(invoice: Invoice)

    @Query("Select * From Invoice")
    fun getAllInvoice(): Flow<List<Invoice>>

}
