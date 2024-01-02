package com.naze.common.data.remote.datasource

import com.umc.bondingwizards.data.remote.api.DummyApi
import com.umc.bondingwizards.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    //API Injection
    val dummyApi: DummyApi
): DummyRepository {
}