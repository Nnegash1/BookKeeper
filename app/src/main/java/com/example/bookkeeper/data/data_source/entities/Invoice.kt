package com.example.bookkeeper.data.data_source.entities

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity
data class Invoice(
    @PrimaryKey(autoGenerate = true)
    val pk: Int = 0,
    @ColumnInfo(name = "Client")
    val client: Client,
    @ColumnInfo(name = "Item")
    val item: List<Item>,
    @ColumnInfo(name = "invoiceDetails")
    val invoiceDetails: InvoiceDetails
)

