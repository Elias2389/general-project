package com.ae.mylibrary.entities.characterslist.presenter

import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.entities.characterslist.interactor.CharactersListInteractor
import com.ae.mylibrary.entities.characterslist.view.CharactersListView
import io.reactivex.disposables.Disposable


class CharactersListPresenterImpl(private val interactor: CharactersListInteractor): CharactersListPresenter {

    private var view: CharactersListView? = null

    init {
        interactor.setPresenter(this)
    }

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

    override fun disposeObserver() {
        this.interactor.disposeObserver()
    }
}