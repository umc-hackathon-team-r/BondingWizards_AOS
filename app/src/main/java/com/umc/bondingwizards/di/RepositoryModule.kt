package com.naze.common.di

import com.naze.common.data.remote.api.DummyApi
import com.naze.common.data.remote.datasource.DummyRepositoryImpl
import com.naze.common.domain.repository.DummyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        dummyApi: DummyApi
    ): DummyRepository = DummyRepositoryImpl(dummyApi)
}