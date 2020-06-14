package com.ae.mylibrary.entities.characterslist.interactor

import com.ae.mylibrary.common.dto.Result

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
}