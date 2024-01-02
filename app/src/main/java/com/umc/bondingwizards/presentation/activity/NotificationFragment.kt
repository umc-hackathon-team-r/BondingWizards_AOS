package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentNotificationBinding
import com.umc.bondingwizards.domain.model.Notification
import com.umc.bondingwizards.presentation.adapter.NotificationAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment: BindingFragment<FragmentNotificationBinding>(R.layout.fragment_notification) {

    private val notiList = listOf(
        Notification(0, "테디 생일", "테디에게 생일 선물을 보내세요"),
        // Add more alarms as needed
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.btnToolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
        setRecyclerView()
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun setRecyclerView(){
        val notificationAdapter = NotificationAdapter(notiList)
        binding.rvNotiList.adapter = notificationAdapter
        binding.rvNotiList.layoutManager = LinearLayoutManager(requireContext())
    }
}