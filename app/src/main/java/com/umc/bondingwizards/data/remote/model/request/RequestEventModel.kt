package com.umc.bondingwizards.data.remote.model.request

data class RequestWritingModel(
    val goal: String = "생일",
    val propensity: List<String> = listOf("친밀함", "일반적인")
)