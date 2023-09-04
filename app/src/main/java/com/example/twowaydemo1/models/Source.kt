package com.example.twowaydemo1.models


import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.Nullable

data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)