package com.ae.mylibrary.entities.characterslist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ae.mylibrary.R
import com.ae.mylibrary.core.BaseApplicationLibrary
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenter
import javax.inject.Inject

class CharactersListActivity : AppCompatActivity(), CharactersListView {

    @Inject
    lateinit var presenter: CharactersListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        (application as BaseApplicationLibrary).getComponent().inject(this)
        fetchData()
    }

    override fun fetchData() {
        presenter.fetchData()
    }

    override fun successData() {
        TODO("Not yet implemented")
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }

}
