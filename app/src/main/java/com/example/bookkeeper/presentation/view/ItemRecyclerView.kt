package com.example.bookkeeper.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookkeeper.databinding.FragmentItemRecyclerViewBinding
import com.example.bookkeeper.presentation.view.adapter.ItemAdapter
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import com.example.bookkeeper.presentation.viewmodel.ItemPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemRecyclerView : Fragment() {

    private val adapter = ItemAdapter()
    @Inject
    lateinit var factory : InvoiceViewModelFactory
    private val arg by navArgs<ItemRecyclerViewArgs>()
    private val vm : ItemPageViewModel by viewModels(){factory}
    private lateinit var binding: FragmentItemRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentItemRecyclerViewBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            vm.listItemState.collect{
                adapter.update(it)
            }
        }
        vm.getItemFromDb(arg.referenceId)
        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
}