package com.umc.bondingwizards.data.remote.datasource

import com.umc.bondingwizards.data.remote.api.EventApi
import com.umc.bondingwizards.data.remote.model.request.RequestWritingModel
import com.umc.bondingwizards.data.remote.model.response.ResponseWritingModel
import com.umc.bondingwizards.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    val eventApi: EventApi
):EventRepository{

    override suspend fun postWriting(): String {
        return eventApi.eventWriting(RequestWritingModel()).body()?.writing ?:""
    }
}