package com.ae.mylibrary.entities.characterslist.interactor

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
    fun successData()

    /**
     * Method to show error case
     *
     */
    fun errorData()
}