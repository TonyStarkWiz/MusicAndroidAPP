package com.android.starwarscatapp.rest

import com.android.starwarscatapp.model.StarWarsPeople
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApi {

    /**
     * Right here I am getting the data from server
     *
     * Using the Single observable to make the asynchronous task
     */
    @GET(STAR_WARS_PEOPLE)
    fun getStarWarsCharacters(): Single<StarWarsPeople>

    /**
     * Companion object will handle the base url and the path
     */
    companion object {
        const val BASE_URL =
            "https://itunes.apple.com/"
        private const val STAR_WARS_PEOPLE = "search?term=rock&amp;media=music&amp;entity=song&amp;limit=50"
    }
}