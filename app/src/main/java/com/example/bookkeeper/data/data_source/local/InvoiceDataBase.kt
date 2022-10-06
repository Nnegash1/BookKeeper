//package com.example.bookkeeper.model
//
//import android.arch.persistence.room.Database
//import android.arch.persistence.room.Room
//import android.arch.persistence.room.RoomDatabase
//import android.content.Context
//import com.example.bookkeeper.model.data.InvoiceData
//
//@Database(entities = [InvoiceData::class], version = 1, exportSchema = false)
//abstract class InvoiceDataBase : RoomDatabase() {
//    abstract fun getDao(): InvoiceDAO
//
//    companion object {
//        private const val INVOICE_NAME = "InvoiceTable.db"
//        private var dbInstance: InvoiceDataBase? = null
//
//        fun getInstance(context: Context): InvoiceDataBase {
//            return dbInstance ?: synchronized(this) {
//                dbInstance ?: createDB(context).also {
//                    dbInstance = it
//                }
//            }
//        }
//
//        private fun createDB(context: Context): InvoiceDataBase {
//            return Room.databaseBuilder(
//                context.applicationContext, InvoiceDataBase::class.java,
//                INVOICE_NAME
//            ).build()
//        }
//    }
//}
