package com.umc.bondingwizards.domain.model

import android.net.Uri

data class Present(
    val id: Int = 0,
    val friendId: Int = 0,
    val image: Uri? = null,
    val price: Int = 0,
)
