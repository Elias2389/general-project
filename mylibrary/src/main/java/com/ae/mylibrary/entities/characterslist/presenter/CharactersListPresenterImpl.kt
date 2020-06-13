package com.ae.mylibrary.entities.characterslist.presenter

import com.ae.mylibrary.entities.characterslist.interactor.CharactersListInteractor
import com.ae.mylibrary.entities.characterslist.view.CharactersListView

class CharactersListPresenterImpl(private val view: CharactersListView,
                                  interactor: CharactersListInteractor): CharactersListPresenter {
    override fun fetchData() {
        TODO("Not yet implemented")
    }

    override fun successData() {
        TODO("Not yet implemented")
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }
}