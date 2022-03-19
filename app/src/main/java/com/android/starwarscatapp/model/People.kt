package com.android.starwarscatapp.model


import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("name")
    val name: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("url")
    val url: String
)