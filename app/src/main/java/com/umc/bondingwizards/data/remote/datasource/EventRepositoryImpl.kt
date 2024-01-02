package com.umc.bondingwizards.data.remote.datasource

import com.umc.bondingwizards.data.remote.api.EventApi
import com.umc.bondingwizards.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    val eventApi: EventApi
):EventRepository{

}