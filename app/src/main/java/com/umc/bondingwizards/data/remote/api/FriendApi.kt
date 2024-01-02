package com.umc.bondingwizards.data.remote.api

import com.umc.bondingwizards.data.remote.model.request.RequestFriendAddModel
import com.umc.bondingwizards.data.remote.model.response.ResponseFriendListModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FriendApi {

    @GET("/api/1/friend")
    suspend fun getFriendList(): Response<ResponseFriendListModel>

    @POST("/api/1/friend")
    suspend fun postFriend(
        @Body param: RequestFriendAddModel
    )

}