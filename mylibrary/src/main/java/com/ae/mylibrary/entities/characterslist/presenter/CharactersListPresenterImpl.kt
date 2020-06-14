package com.ae.mylibrary.entities.characterslist.presenter

import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.entities.characterslist.interactor.CharactersListInteractor
import com.ae.mylibrary.entities.characterslist.view.CharactersListView


class CharactersListPresenterImpl(private val interactor: CharactersListInteractor): CharactersListPresenter {

    private var view: CharactersListView? = null

    override fun fetchData() {
        interactor.fetchData()
    }

    override fun successData(results: List<Result>) {
        this.view?.successData(results)
    }

    override fun errorData() {
        this.view?.errorData()
    }

    override fun setView(view: CharactersListView) {
        this.view = view
    }
}