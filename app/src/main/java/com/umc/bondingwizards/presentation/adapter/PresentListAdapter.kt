package com.umc.bondingwizards.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.bondingwizards.databinding.ItemFriendBinding
import com.umc.bondingwizards.domain.model.Friend
import com.umc.bondingwizards.domain.viewmodel.ListViewModel
import com.umc.bondingwizards.utils.ItemDiffCallback

class PresentListAdapter(private val viewModel: ListViewModel): ListAdapter<Friend, RecyclerView.ViewHolder>(
    ItemDiffCallback<Friend>(
        onContentsTheSame = {old, new -> old == new},
        onItemsTheSame = {old, new -> old.name == new.name}
    )
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FriendViewHolder(ItemFriendBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        when (holder) {
            is FriendViewHolder -> {
                holder.bind(item)
            }
        }
    }

    inner class FriendViewHolder(
        private val binding: ItemFriendBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Friend) {
            binding.friend = item
            binding.vm = viewModel

            Log.d("TEST List","왜 안떠")
        }
    }
}