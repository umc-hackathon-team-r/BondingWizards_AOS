package com.umc.bondingwizards.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.bondingwizards.databinding.ItemPlanBinding

class PlanRVAdapter(val items: ArrayList<String>): RecyclerView.Adapter<PlanRVAdapter.ViewHolder>() {

    interface MyItemClickListner{ //item clicklistner를 저장하기 위한 인터페이스
        fun onPlusClick(plan : String)
    }

    private lateinit var mItemClickListner: MyItemClickListner //아래 받은 것을 내부에서 사용하기 위해 선언
    fun setMyItemClickLitner(itemClickListner: MyItemClickListner) { //외부에서의 itemClickListner를 받기 위한 함수
        mItemClickListner = itemClickListner
    }

    inner class ViewHolder(val binding: ItemPlanBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanRVAdapter.ViewHolder {
        val binding = ItemPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanRVAdapter.ViewHolder, position: Int) {
        holder.binding.planTitle.text = items[position]
    }

    override fun getItemCount(): Int = items.size

}