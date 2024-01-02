package com.umc.bondingwizards.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.bondingwizards.databinding.ItemEventPresentBinding
import com.umc.bondingwizards.domain.model.Friend   // 추후 Friend -> Present로 바꾸기
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.utils.ItemDiffCallback

class EventInfoAdapter(private val viewModel: ListViewModel) : ListAdapter<Friend, RecyclerView.ViewHolder>( // 추후 Friend -> Present로 바꾸기
    ItemDiffCallback<Friend>( // 추후 Friend -> Present로 바꾸기
        onContentsTheSame = {old, new -> old == new},
        onItemsTheSame = {old, new -> old.name == new.name}
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventInfoViewHolder(ItemEventPresentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        when(holder){
            is EventInfoViewHolder -> {
//                holder.bind(item)
            }
        }
    }

    inner class EventInfoViewHolder(
        private val itemBinding: ItemEventPresentBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
//          fun bind(item: Present)  {
//              itemBinding.present = item
//              itemBinding.vm = viewModel
//          }
        }

}