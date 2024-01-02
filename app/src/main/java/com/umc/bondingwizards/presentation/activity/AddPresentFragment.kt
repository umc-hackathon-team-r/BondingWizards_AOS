package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentAddPresentBinding
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.presentation.adapter.FriendListAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPresentFragment: BindingFragment<FragmentAddPresentBinding>(R.layout.fragment_add_present) {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.present = viewModel
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner

        setRecyclerView()

    }

    private fun setRecyclerView() {
        val friendAdapter = FriendListAdapter(viewModel)
        binding.rvFriendList.apply {
            adapter = friendAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        viewModel.friendList.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch (Dispatchers.Main) {
                friendAdapter.submitList(it)
            }
        }
    }
}