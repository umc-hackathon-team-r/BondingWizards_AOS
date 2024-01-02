package com.naze.common.data.remote.datasource

import com.naze.common.data.remote.api.DummyApi
import com.naze.common.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    //API Injection
    val dummyApi: DummyApi
): DummyRepository {
}