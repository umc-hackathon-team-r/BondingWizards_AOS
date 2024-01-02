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
        Notification(0, "테디 생일", "테디님의 생일에 대한 정보를 확인해보세요."),
        Notification(1, "새해", "오늘은 새해 첫날입니다. 소중한 사람들에게 메세지를 보내보시는건 어떠신가요?"),
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