package com.umc.bondingwizards.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.bondingwizards.databinding.ItemPresentBinding
import com.umc.bondingwizards.domain.model.Friend
import com.umc.bondingwizards.domain.model.Present
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.utils.ItemDiffCallback

class PresentListAdapter(private val viewModel: ListViewModel): ListAdapter<Present, RecyclerView.ViewHolder>(
    ItemDiffCallback<Present>(
        onContentsTheSame = {old, new -> old == new},
        onItemsTheSame = {old, new -> old.id == new.id}
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PresentViewHolder(ItemPresentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        when (holder) {
            is PresentViewHolder -> {
                holder.bind(item)
            }
        }
    }

    inner class PresentViewHolder(
        private val binding: ItemPresentBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Present) {
            binding.present = item
            binding.vm = viewModel
        }
    }
}