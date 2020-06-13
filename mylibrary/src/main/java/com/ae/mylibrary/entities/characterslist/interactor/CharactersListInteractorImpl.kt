package com.ae.mylibrary.entities.characterslist.interactor

import android.annotation.SuppressLint
import android.util.Log
import com.ae.mylibrary.common.service.CharactersListService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

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

    override fun successData() {
        TODO("Not yet implemented")
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }
}