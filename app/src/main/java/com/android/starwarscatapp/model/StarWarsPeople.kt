package com.android.starwarscatapp.model


import com.google.gson.annotations.SerializedName

data class StarWarsPeople(
    @SerializedName("message")
    val message: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val people: List<People>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_records")
    val totalRecords: Int
)