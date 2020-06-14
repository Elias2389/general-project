package com.ae.mylibrary.entities.characterslist.view

import com.ae.mylibrary.common.dto.Result

interface CharactersListView {
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