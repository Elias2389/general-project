package com.ae.mylibrary.entities.characterdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ae.mylibrary.R

class CharactersListActivity : AppCompatActivity(), CharactersListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
    }

    override fun fetchData() {
        TODO("Not yet implemented")
    }

    override fun successData() {
        TODO("Not yet implemented")
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }
}
