package com.android.starwarscatapp.rest

import com.android.starwarscatapp.model.TrackMusic
import io.reactivex.Single
import retrofit2.http.GET

interface StarWarsApi {

    //https://itunes.apple.com/
    // search
    // ?term=pop&media=music&amp;entity=song&amp;limit=50

    /**
     * Right here I am getting the data from server
     *
     * Using the Single observable to make the asynchronous task
     */
    @GET(STAR_WARS_PEOPLE)
    fun getMusic(
//        @Query("media") media: String = "music",
//        @Query("entity") entity: String = "song",
//        @Query("limit") limit: Int = 50
    ): Single<TrackMusic>

    /**
     * Companion object will handle the base url and the path
     */
    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
        private const val STAR_WARS_PEOPLE = "search?term=rock&amp;media=music&amp;entity=song&amp;limit=50"
    }
}