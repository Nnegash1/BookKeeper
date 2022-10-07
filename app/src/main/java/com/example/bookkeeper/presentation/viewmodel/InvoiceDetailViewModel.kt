package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookkeeper.data.data_source.entities.Client
import com.example.bookkeeper.data.data_source.entities.Invoice
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.data.data_source.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.ClientFragmentState
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceDetailState
import com.example.bookkeeper.presentation.viewmodel.state.ItemScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InvoiceDetailViewModel : ViewModel() {

    private val itemContainer: MutableList<Item> = mutableListOf()
    private val _client: MutableStateFlow<ClientFragmentState> =
        MutableStateFlow(ClientFragmentState())
    private val _invoiceDetail: MutableStateFlow<InvoiceDetailState> =
        MutableStateFlow(InvoiceDetailState())
    private val _item: MutableStateFlow<ItemScreenState> =
        MutableStateFlow(ItemScreenState(mutableListOf()))

    val invoiceDetail get() = _invoiceDetail.asStateFlow()
    val item get() = _item.asStateFlow()
    val client get() = _client.asStateFlow()

    fun clientUpdate(client: Client) {
        _client.value = ClientFragmentState(client)
    }

    fun addItem(item: Item) {
        itemContainer.add(item)
        _item.value = ItemScreenState(itemContainer)
    }

    fun addInvoice() {
        val invoice = client.value.client?.let {
            Invoice(
                client = it,
                item = item.value.item,
                invoiceDetails = invoiceDetail.value.invoice
            )
        }
        if (invoice != null) {
            InvoiceRepository.addInvoice(invoice)
        }
    }

    fun detailUpdate(invoice: InvoiceDetails) = viewModelScope.launch {
        _invoiceDetail.value = InvoiceDetailState(invoice)
    }

    fun clear() {
        itemContainer.clear()
        _item.value = ItemScreenState(itemContainer)
    }

}