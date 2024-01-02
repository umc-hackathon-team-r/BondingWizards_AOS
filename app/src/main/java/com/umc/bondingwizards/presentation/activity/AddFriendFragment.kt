package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentFriendAddBinding
import com.umc.bondingwizards.domain.model.Friend
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.utils.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFriendFragment: BindingFragment<FragmentFriendAddBinding>(R.layout.fragment_friend_add) {
    private val viewModel: ListViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createBtn.setOnClickListener {
           viewModel.addFriend(Friend(3, binding.nameEt.text.toString(), binding.phoneEt.text.toString()))
            parentFragmentManager.beginTransaction().replace(R.id.fl_list,ListFriendFragment()).commit()
        }

        binding.cancelBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_list,ListFriendFragment()).commit()
        }
    }

}