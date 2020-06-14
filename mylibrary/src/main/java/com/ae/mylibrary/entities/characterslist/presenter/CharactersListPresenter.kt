package com.ae.mylibrary.entities.characterslist.presenter

import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.entities.characterslist.view.CharactersListView

interface CharactersListPresenter {
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
     * Method to set view
     *
     */
    fun setView(view: CharactersListView)
}