package com.example.bookkeeper.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookkeeper.R
import com.example.bookkeeper.databinding.FragmentHomePageBinding
import com.example.bookkeeper.ui.adapter.InvoiceAdapter
import com.example.bookkeeper.viewmodel.InvoiceViewModel
import com.example.bookkeeper.viewmodel.UIState
import kotlinx.coroutines.flow.collectLatest

class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding
    private val vm: InvoiceViewModel by viewModels()
    private val adapter = InvoiceAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomePageBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            vm.uiState.collectLatest {
                if (it is UIState.Success) {
                    adapter.update(it.data.invoiceData)
                }
            }
        }
      
        initAdapter()
        vm.getAllInvoice()
    }

    private fun initAdapter() {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireActivity())
            recyclerView.adapter = adapter
        }
    }
}