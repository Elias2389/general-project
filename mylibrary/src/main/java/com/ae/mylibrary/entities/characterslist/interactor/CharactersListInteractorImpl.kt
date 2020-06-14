package com.ae.mylibrary.entities.characterslist.interactor

import android.annotation.SuppressLint
import android.util.Log
import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.common.service.CharactersListService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CharactersListInteractorImpl(private val charactersListService: CharactersListService):
    CharactersListInteractor {

    @SuppressLint("CheckResult")
    override fun fetchData() {
        charactersListService
            .getCharacterList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ success ->
                Log.i("Prueba->", success.toString())
            }, {

            })
    }

    override fun successData(results: List<Result>) {
        TODO("Not yet implemented")
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }
}