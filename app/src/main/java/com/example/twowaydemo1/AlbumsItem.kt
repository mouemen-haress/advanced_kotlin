package com.example.twowaydemo1


import com.google.gson.annotations.SerializedName

data class AlbumsItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)