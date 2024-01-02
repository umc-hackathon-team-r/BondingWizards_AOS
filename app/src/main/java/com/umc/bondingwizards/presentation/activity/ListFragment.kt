package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentListBinding
import com.umc.bondingwizards.domain.type.ListItem
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment: BindingFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val viewModel: ListViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list = viewModel
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.tabPresent.setOnClickListener {
            viewModel.changeListState(ListItem.PRESENT)
        }

        binding.tabFriend.setOnClickListener {
            viewModel.changeListState(ListItem.FRIEND)
        }

        viewModel.listState.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                Log.d("Switch Text", childFragmentManager.fragments.toString())
                when (it) {
                    ListItem.FRIEND -> {
                        childFragmentManager.beginTransaction().replace(R.id.fl_list, ListFriendFragment()).commit()
                    }
                    ListItem.PRESENT -> {
                        childFragmentManager.beginTransaction().replace(R.id.fl_list, ListPresentFragment()).commit()
                    }
                }
            }
        }
    }
}