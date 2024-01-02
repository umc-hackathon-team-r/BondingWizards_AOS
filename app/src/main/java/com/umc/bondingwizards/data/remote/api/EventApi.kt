package com.umc.bondingwizards.data.remote.api

import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param
import com.umc.bondingwizards.data.remote.model.request.RequestWritingModel
import com.umc.bondingwizards.data.remote.model.response.ResponseWritingModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface EventApi {
    @POST("/api/event/writing")
    suspend fun eventWriting(
        @Body param: RequestWritingModel,
    ): Response<ResponseWritingModel>

}