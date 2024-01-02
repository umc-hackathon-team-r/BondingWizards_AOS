package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentRecommandWritingBinding
import com.umc.bondingwizards.presentation.adapter.FlexBoxAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment

class RecommendWritingFragment : BindingFragment<FragmentRecommandWritingBinding>(R.layout.fragment_recommand_writing){

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonTextList = listOf("새해","생일","결혼기념일","명절","크리스마스","커플")

        flexBoxAdapter = FlexBoxAdapter(buttonTextList) { buttonText, selected ->
            // 버튼 클릭 이벤트 처리
            if (selected) {

            } else {

            }
        }


        FlexboxLayoutManager(context).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }.let {
            binding.rvKeyword.layoutManager = it
            binding.rvKeyword.adapter = flexBoxAdapter
        }

        binding.btnNext.setOnClickListener {
            Log.d("TEST" ,"tlqkf")
            findNavController().navigate(
                R.id.action_recommendWritingFragment_to_recommendWriting2Fragment
            )
        }

    }
}