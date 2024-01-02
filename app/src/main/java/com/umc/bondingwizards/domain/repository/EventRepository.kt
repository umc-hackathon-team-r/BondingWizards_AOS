package com.umc.bondingwizards.domain.repository

interface EventRepository {
    suspend fun postWriting(): String
}