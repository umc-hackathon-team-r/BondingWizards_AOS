package com.umc.bondingwizards.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.bondingwizards.databinding.ItemNotificationBinding
import com.umc.bondingwizards.domain.model.Notification

class NotificationAdapter(private val notiList: List<Notification>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun getItemCount(): Int {
        return notiList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val noti = notiList[position]
        holder.bind(noti)
    }

    inner class NotificationViewHolder(private val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(notification: Notification){
            binding.notification = notification
            binding.executePendingBindings()
        }
    }
}