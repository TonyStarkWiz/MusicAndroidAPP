package com.android.starwarscatapp

import android.app.Application
import com.android.starwarscatapp.di.ApplicationModule
import com.android.starwarscatapp.di.DaggerStarWarsComponent
import com.android.starwarscatapp.di.StarWarsComponent

class StarWarsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        starWarsComponent = DaggerStarWarsComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var starWarsComponent: StarWarsComponent
    }
}