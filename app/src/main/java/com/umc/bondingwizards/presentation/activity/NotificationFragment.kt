package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentNotificationBinding
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment: BindingFragment<FragmentNotificationBinding>(R.layout.fragment_notification) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.btnToolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}