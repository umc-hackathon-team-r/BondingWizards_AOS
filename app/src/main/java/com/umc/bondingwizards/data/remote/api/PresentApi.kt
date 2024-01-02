package com.umc.bondingwizards.data.remote.api

import com.umc.bondingwizards.data.remote.model.request.RequestFriendAddModel
import com.umc.bondingwizards.data.remote.model.response.ResponseFriendListModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PresentApi {
    @GET("/api/1/present")
    suspend fun getPresentList(): Response<ResponseFriendListModel>

    @POST("/api/present")
    suspend fun postPresent(
        @Body param: RequestFriendAddModel
    )
}