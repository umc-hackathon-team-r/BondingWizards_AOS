package com.umc.bondingwizards.data.remote.model.response

data class PresentModel(
    val title: String = "제목",
    val description:String = "설명",
    val price:Int = 10000,
    val category: String = "",
    val name:String ="훈이",
    val picture:String = "aws s3 주소",
    val userId:Int = 1
)
{
}