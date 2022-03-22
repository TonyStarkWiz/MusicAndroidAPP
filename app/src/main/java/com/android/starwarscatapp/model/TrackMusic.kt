package com.android.starwarscatapp.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrackMusic(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
) : Serializable