//package com.example.bookkeeper.model
//
//import android.arch.persistence.room.Dao
//import android.arch.persistence.room.Delete
//import android.arch.persistence.room.Insert
//import android.arch.persistence.room.Query
//import com.example.bookkeeper.model.data.InvoiceData
//
//@Dao
//interface InvoiceDAO {
//    @Insert
//    fun insertAll(vararg users: InvoiceData)
//
//    @Delete
//    fun delete(invoiceData: InvoiceData)
//
//    @Query("SELECT * FROM InvoiceData")
//    fun getAllInvoice(): InvoiceData
//
//}
