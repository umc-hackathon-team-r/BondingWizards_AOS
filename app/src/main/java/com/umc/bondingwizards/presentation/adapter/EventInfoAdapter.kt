package com.umc.bondingwizards.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.bondingwizards.databinding.ItemEventPresentBinding

class EventInfoAdapter() : RecyclerView.Adapter<EventInfoAdapter.EventInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventInfoViewHolder {
        val itemBinding: ItemEventPresentBinding = ItemEventPresentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventInfoViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EventInfoViewHolder, position: Int) {
        holder.itemView.setOnClickListener{

        }
    }

    class EventInfoViewHolder(
        private val itemBinding: ItemEventPresentBinding)
        : RecyclerView.ViewHolder(itemBinding.root){

        }

}