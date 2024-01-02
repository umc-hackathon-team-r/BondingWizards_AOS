package com.umc.bondingwizards.presentation.activity

import android.view.View
import androidx.navigation.fragment.findNavController
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import com.umc.bondingwizards.databinding.FragmentCalendarBinding
import com.umc.bondingwizards.utils.binding.BindingFragment


@AndroidEntryPoint
class CalendarFragment: BindingFragment<FragmentCalendarBinding>(com.umc.bondingwizards.R.layout.fragment_calendar) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}