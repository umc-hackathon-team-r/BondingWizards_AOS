package com.naze.common.di

import com.umc.bondingwizards.data.remote.api.DummyApi
import com.naze.common.data.remote.datasource.DummyRepositoryImpl
import com.umc.bondingwizards.domain.repository.DummyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        dummyApi: DummyApi
    ): DummyRepository = DummyRepositoryImpl(dummyApi)
}