package com.umc.bondingwizards.data.remote.model.response

data class ResponseFriendListModel (
    val count: Int,
    val data: List<FriendList>
)

data class FriendList(
    val friendId: Int,
    val friendName: String,
)