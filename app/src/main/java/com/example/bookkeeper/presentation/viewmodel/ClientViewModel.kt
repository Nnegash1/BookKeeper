package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookkeeper.data.data_source.entities.Client
import com.example.bookkeeper.presentation.viewmodel.state.ClientFragmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ClientViewModel : ViewModel() {
    private val _client: MutableStateFlow<ClientFragmentState> =
        MutableStateFlow(ClientFragmentState())
    val client get() = this._client.asStateFlow()

    fun updateState(clientInformation: Client) {
        _client.value = ClientFragmentState(clientInformation)
    }
}