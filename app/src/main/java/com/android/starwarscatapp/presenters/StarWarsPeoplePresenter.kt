package com.android.starwarscatapp.presenters

import android.provider.Contacts
import com.android.starwarscatapp.model.Result
import com.android.starwarscatapp.model.TrackMusic
import com.android.starwarscatapp.rest.StarWarsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StarWarsPeoplePresenterImpl @Inject constructor(
    private val starWarsRepository: StarWarsRepository,
    private val disposables: CompositeDisposable
) : StarWarsPeoplePresenter {

    private var peopleViewContract: PeopleViewContract? = null

    override fun initializePresenter(viewContract: PeopleViewContract) {
        peopleViewContract = viewContract
    }

    override fun checkNetworkConnection() {
        // no - op
    }

    override fun getStarWarsCharacters() {
        peopleViewContract?.loadingCharacters(true)

        starWarsRepository.getPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { characters -> peopleViewContract?.charactersSuccess(characters.results) },
                { error -> peopleViewContract?.onError(error) }
            )
            .apply {
                disposables.add(this)
            }
    }

    override fun destroyPresenter() {
        peopleViewContract = null
        disposables.clear()
    }
}

interface StarWarsPeoplePresenter {
    fun initializePresenter(viewContract: PeopleViewContract)
    fun checkNetworkConnection()
    fun getStarWarsCharacters()
    fun destroyPresenter()
}

interface PeopleViewContract {
    fun loadingCharacters(isLoading: Boolean)
    fun charactersSuccess(characters: List<Result>)
    fun onError(error: Throwable)
}