package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentEventinfoBinding
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.presentation.adapter.EventInfoAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventInfoFragment: BindingFragment<FragmentEventinfoBinding>(R.layout.fragment_eventinfo) {
    private val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.present = viewModel
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.recommBtn.setOnClickListener {

        }
    }

    private fun setRecyclerView() {
        val eventInfoAdapter = EventInfoAdapter(viewModel)
        binding.eventRv.apply {
            adapter = eventInfoAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }


    }

}