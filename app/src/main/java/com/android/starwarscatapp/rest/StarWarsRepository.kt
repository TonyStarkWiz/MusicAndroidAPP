package com.android.starwarscatapp.rest

import com.android.starwarscatapp.model.TrackMusic
import io.reactivex.Single
import javax.inject.Inject

interface StarWarsRepository {
    fun getPeople(): Single<TrackMusic>
    fun getClassic() : Single<TrackMusic>
    fun getPop() : Single<TrackMusic>
}

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsApi: StarWarsApi
) : StarWarsRepository {

    override fun getPeople(): Single<TrackMusic> {
        return starWarsApi.getMusic()
    }

    override fun getClassic(): Single<TrackMusic> {
        return starWarsApi.getClassic()
    }

    override fun getPop(): Single<TrackMusic> {
        return starWarsApi.getPop()
    }
}