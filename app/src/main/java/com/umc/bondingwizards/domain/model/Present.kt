package com.umc.bondingwizards.domain.model

import android.net.Uri

data class Present(
    val id: Int = 0,
    val title: String = "oo씨의 선물",
    val image: Uri? = null,
    val price: String = "19,800원",
)
