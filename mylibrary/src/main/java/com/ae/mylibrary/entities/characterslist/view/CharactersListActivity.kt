package com.ae.mylibrary.entities.characterslist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ae.mylibrary.R
import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.core.BaseApplicationLibrary
import com.ae.mylibrary.entities.characterslist.adapter.CharacterListAdapter
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenter
import javax.inject.Inject

class CharactersListActivity : AppCompatActivity(), CharactersListView {

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var charactersList: List<Result>
    private lateinit var adapter: CharacterListAdapter

    @Inject
    lateinit var presenter: CharactersListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        (application as BaseApplicationLibrary).getComponent().inject(this)

        recyclerView = findViewById(R.id.character_container)


        presenter.setView(this)

        fetchData()

    }

    override fun fetchData() {
        presenter.fetchData()
    }

    override fun successData(results: List<Result>) {
        layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = CharacterListAdapter(results, this)
        recyclerView.adapter = adapter
    }

    override fun errorData() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeObserver()
    }
}
