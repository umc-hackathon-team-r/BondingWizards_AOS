package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentEventinfoBinding
import com.umc.bondingwizards.presentation.adapter.EventInfoAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventInfoFragment: BindingFragment<FragmentEventinfoBinding>(R.layout.fragment_eventinfo) {
    private lateinit var eventInfoAdapter: EventInfoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eventRv.adapter = eventInfoAdapter

        binding.recommBtn.setOnClickListener {

        }
    }


}