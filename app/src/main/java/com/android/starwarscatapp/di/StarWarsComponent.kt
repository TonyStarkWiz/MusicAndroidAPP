package com.android.starwarscatapp.di

import com.android.starwarscatapp.MainActivity
import com.android.starwarscatapp.views.PeopleFragment
import com.android.starwarscatapp.views.PlanetsFragment
import com.android.starwarscatapp.views.StarShipsFragment
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        ApplicationModule::class,
        PresentersModule::class
    ]
)

@Singleton
interface StarWarsComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(peopleFragment: PeopleFragment)
    fun inject(starShipsFragment: StarShipsFragment)
    fun inject(planetsFragment: PlanetsFragment)
}