package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookkeeper.data.data_source.entities.Client
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.ClientFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ClientViewModel @Inject constructor(private val repo: InvoiceRepository) : ViewModel() {
    private val _client: MutableStateFlow<ClientFragmentState> =
        MutableStateFlow(ClientFragmentState())
    val client get() = this._client.asStateFlow()

    fun updateState(clientInformation: Client) {
        _client.value = ClientFragmentState(clientInformation)
    }
}