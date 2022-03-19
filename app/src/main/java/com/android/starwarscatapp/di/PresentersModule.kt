package com.android.starwarscatapp.di

import com.android.starwarscatapp.presenters.StarWarsPeoplePresenter
import com.android.starwarscatapp.presenters.StarWarsPeoplePresenterImpl
import com.android.starwarscatapp.rest.StarWarsRepository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PresentersModule {

    @Provides
    fun providesCompositeDisposable() = CompositeDisposable()

    @Provides
    fun providesCharactersPresenter(
        starWarsRepository: StarWarsRepository,
        disposable: CompositeDisposable
    ): StarWarsPeoplePresenter {
        return StarWarsPeoplePresenterImpl(starWarsRepository, disposable)
    }
}