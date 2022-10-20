package com.example.bookkeeper.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.bookkeeper.data.data_source.entities.Item
import com.example.bookkeeper.data.data_source.local.itemContainer
import com.example.bookkeeper.domain.repository.InvoiceRepository
import com.example.bookkeeper.presentation.viewmodel.state.ClientFragmentState
import com.example.bookkeeper.presentation.viewmodel.state.InvoiceDetailState
import com.example.bookkeeper.presentation.viewmodel.state.ItemScreenState
import com.example.bookkeeper.testUtil.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.*
import org.junit.Assert.*

class InvoiceDetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: InvoiceDetailViewModel
    private val repo: InvoiceRepository = mockk()


    @Before
    fun setUp() {
        viewModel = InvoiceDetailViewModel(repo)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `testing when viewModel is created`() {
        assertEquals(viewModel.client.value, ClientFragmentState())
        assertEquals(viewModel.invoiceDetail.value, InvoiceDetailState())
        assertEquals(viewModel.item.value, ItemScreenState())
        assertEquals(viewModel.item.value.item, emptyList<Item>())
    }

    @Test
    fun getInvoiceDetail() {

    }

    @Test
    fun addItem() {
        // Given
        val item: Item = Item("Testing")
        coEvery { viewModel.addItem(item) } coAnswers { Unit }
    }

    @Test
    fun addInvoice() {
    }

    @Test
    fun detailUpdate() {
    }
}