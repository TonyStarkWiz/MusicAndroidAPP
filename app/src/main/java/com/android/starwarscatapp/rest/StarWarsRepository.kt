package com.android.starwarscatapp.rest

import com.android.starwarscatapp.model.StarWarsPeople
import io.reactivex.Single
import javax.inject.Inject

interface StarWarsRepository {
    fun getPeople(): Single<StarWarsPeople>
}

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsApi: StarWarsApi
) : StarWarsRepository {

    override fun getPeople(): Single<StarWarsPeople> {
        return starWarsApi.getStarWarsCharacters()
    }
}