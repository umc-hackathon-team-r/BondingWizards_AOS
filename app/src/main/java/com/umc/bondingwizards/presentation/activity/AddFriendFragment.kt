package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentFriendAddBinding
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFriendFragment: BindingFragment<FragmentFriendAddBinding>(R.layout.fragment_friend_add) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.createBtn.setOnClickListener {

        }

        binding.cancelBtn.setOnClickListener {

        }
    }

}