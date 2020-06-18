package com.ae.mylibrary.entities.characterslist.interactor

import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenter
import com.ae.mylibrary.entities.characterslist.view.CharactersListView
import io.reactivex.disposables.Disposable

interface CharactersListInteractor {
    /**
     * Method to Fetch data from Rest API
     *
     */
    fun fetchData()

    /**
     * Method to show success case
     *
     */
    fun successData(results: List<Result>)

    /**
     * Method to show error case
     *
     */
    fun errorData()

    /**
     * Method to set presenter
     *
     */
    fun setPresenter(presenter: CharactersListPresenter)

    /**
     * Methods to dispose
     *
     */
    fun disposeObserver()

}