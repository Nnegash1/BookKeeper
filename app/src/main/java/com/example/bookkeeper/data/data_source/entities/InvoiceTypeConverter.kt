package com.example.bookkeeper.data.data_source.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class InvoiceTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun clientToGson(invoice: Client): String {
        return gson.toJson(invoice)
    }

    @TypeConverter
    fun gsonToClient(invoice: String): Client {
        val objectType = object : TypeToken<Client>() {}.type
        return gson.fromJson(invoice, objectType)
    }


    @TypeConverter
    fun itemToGson(item: List<Item>): String {
        return gson.toJson(item)
    }

    @TypeConverter
    fun gsonToItem(item: String): List<Item> {
        val objectType = object : TypeToken<List<Item>>() {}.type
        return gson.fromJson(item, objectType)
    }

    @TypeConverter
    fun detailToGson(invoiceDetails: InvoiceDetails): String {
        return gson.toJson(invoiceDetails)
    }

    @TypeConverter
    fun gsonToDetail(invoiceDetails: String): InvoiceDetails {
        val objectType = object : TypeToken<InvoiceDetails>() {}.type
        return gson.fromJson(invoiceDetails, objectType)
    }
}