package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.umc.bondingwizards.R
import com.umc.bondingwizards.databinding.FragmentRecommandWriting2Binding
import com.umc.bondingwizards.databinding.FragmentRecommandWritingBinding
import com.umc.bondingwizards.presentation.adapter.FlexBoxAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment

class RecommendWriting2Fragment : BindingFragment<FragmentRecommandWriting2Binding>(R.layout.fragment_recommand_writing2){

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonTextList = listOf("친근한","전문적인","감사의","낭만적인","유머 있는","창의적인")

        flexBoxAdapter = FlexBoxAdapter(buttonTextList) { buttonText, selected ->
            // 버튼 클릭 이벤트 처리
            if (selected) {

            } else {

            }
            Toast.makeText(context,"클릭한 버튼: $buttonText", Toast.LENGTH_SHORT).show()
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
            findNavController().navigate(
                R.id.action_recommendWriting2Fragment_to_recommendWriting3Fragment2
            )
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}