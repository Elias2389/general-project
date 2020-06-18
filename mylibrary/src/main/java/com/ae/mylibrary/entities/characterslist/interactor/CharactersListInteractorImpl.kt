package com.ae.mylibrary.entities.characterslist.interactor

import android.annotation.SuppressLint
import android.util.Log
import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.common.service.CharactersListService
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenter
import com.ae.mylibrary.entities.characterslist.view.CharactersListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CharactersListInteractorImpl(private val charactersListService: CharactersListService):
    CharactersListInteractor {

    private var presenter: CharactersListPresenter? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun fetchData() {

        compositeDisposable.add(
            charactersListService
                .getCharacterList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    successData(success.results)
                }, {

                })
        )
    }

    override fun successData(results: List<Result>) {
        this.presenter?.successData(results)
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: CharactersListPresenter) {
        this.presenter = presenter
    }

    override fun disposeObserver() {
        compositeDisposable.clear()
    }

}