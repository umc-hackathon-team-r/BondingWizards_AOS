package com.umc.bondingwizards.data.remote.datasource

import com.umc.bondingwizards.data.remote.api.EventApi
import com.umc.bondingwizards.data.remote.api.FriendApi
import com.umc.bondingwizards.domain.repository.EventRepository
import com.umc.bondingwizards.domain.repository.FriendRepository
import javax.inject.Inject

class FriendRepositoryImpl @Inject constructor(
    val friendApi: FriendApi
):FriendRepository{

}