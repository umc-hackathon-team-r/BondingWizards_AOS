package com.umc.bondingwizards.presentation.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.umc.bondingwizards.databinding.BottomSheetBinding
import com.umc.bondingwizards.presentation.adapter.PlanRVAdapter

class PlanBottomSheet(val planList: ArrayList<String>) : BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBinding.inflate(layoutInflater)

        val sheet = binding.bottomSheet
        val behaviour = BottomSheetBehavior.from(sheet)
        behaviour.state = BottomSheetBehavior.STATE_EXPANDED


        val planRVAdapter = PlanRVAdapter(planList)
        binding.bottomRv.adapter = planRVAdapter
        binding.bottomRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.bottomSheetUpload.setOnClickListener{
            val plan: String = binding.bottomSheetEt.text.toString()
            planList.add(plan)
            val planRVAdapter = PlanRVAdapter(planList)
            binding.bottomRv.adapter = planRVAdapter
            binding.bottomRv.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        binding.bottomSheetEt.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.bottomSheetUpload.visibility = View.GONE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.isEmpty() == true){
                    binding.bottomSheetUpload.visibility = View.GONE
                }else{
                    binding.bottomSheetUpload.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        return binding.root
    }
}