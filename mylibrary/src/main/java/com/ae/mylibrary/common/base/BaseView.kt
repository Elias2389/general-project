package com.ae.mylibrary.common.base

interface BaseView {
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