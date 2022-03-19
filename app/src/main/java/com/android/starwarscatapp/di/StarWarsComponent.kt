package com.android.starwarscatapp.di

import com.android.starwarscatapp.MainActivity
import com.android.starwarscatapp.views.PeopleFragment
import com.android.starwarscatapp.views.PlanetsFragment
import com.android.starwarscatapp.views.StarShipsFragment
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        ApplicationModule::class,
        PresentersModule::class
    ]
)
interface StarWarsComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(peopleFragment: PeopleFragment)
    fun inject(starShipsFragment: StarShipsFragment)
    fun inject(planetsFragment: PlanetsFragment)
}