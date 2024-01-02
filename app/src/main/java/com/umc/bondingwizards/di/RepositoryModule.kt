package com.naze.common.di

import com.umc.bondingwizards.data.remote.api.DummyApi
import com.naze.common.data.remote.datasource.DummyRepositoryImpl
import com.umc.bondingwizards.data.remote.api.EventApi
import com.umc.bondingwizards.data.remote.api.FriendApi
import com.umc.bondingwizards.data.remote.api.PresentApi
import com.umc.bondingwizards.data.remote.datasource.EventRepositoryImpl
import com.umc.bondingwizards.data.remote.datasource.FriendRepositoryImpl
import com.umc.bondingwizards.data.remote.datasource.PresentRepositoryImpl
import com.umc.bondingwizards.domain.repository.DummyRepository
import com.umc.bondingwizards.domain.repository.EventRepository
import com.umc.bondingwizards.domain.repository.FriendRepository
import com.umc.bondingwizards.domain.repository.PresentRepository
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

    @Provides
    fun provideEventRepository(
        eventApi: EventApi
    ): EventRepository = EventRepositoryImpl(eventApi)

    @Provides
    fun provideFriendRepository(
        friendApi: FriendApi
    ): FriendRepository = FriendRepositoryImpl(friendApi)

    @Provides
    fun providePresentRepository(
        presentApi: PresentApi
    ): PresentRepository = PresentRepositoryImpl(presentApi)
}