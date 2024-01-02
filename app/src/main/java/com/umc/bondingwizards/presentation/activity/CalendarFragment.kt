package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentCalendarBinding
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment: BindingFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToolbarNoti.setOnClickListener {
            findNavController().navigate(
                R.id.action_calendarFragment_to_notificationFragment
            )
        }
    }

}