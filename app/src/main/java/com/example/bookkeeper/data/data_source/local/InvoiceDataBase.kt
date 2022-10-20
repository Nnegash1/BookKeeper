package com.example.bookkeeper.data.data_source.local


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bookkeeper.data.data_source.entities.*

@Database(
    entities = [Invoice::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(InvoiceTypeConverter::class)
abstract class InvoiceDataBase : RoomDatabase() {
    abstract fun getDao(): InvoiceDAO
    companion object {
        const val INVOICE_NAME = "InvoiceTable.db"
    }
}
