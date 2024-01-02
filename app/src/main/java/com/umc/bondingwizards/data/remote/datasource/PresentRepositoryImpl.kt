package com.umc.bondingwizards.data.remote.datasource

import com.umc.bondingwizards.data.remote.api.EventApi
import com.umc.bondingwizards.data.remote.api.PresentApi
import com.umc.bondingwizards.domain.repository.EventRepository
import com.umc.bondingwizards.domain.repository.PresentRepository
import javax.inject.Inject

class PresentRepositoryImpl @Inject constructor(
    val presentApi: PresentApi
):PresentRepository{

}