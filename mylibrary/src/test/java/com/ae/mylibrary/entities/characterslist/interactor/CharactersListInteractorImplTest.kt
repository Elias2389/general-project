package com.ae.mylibrary.entities.characterslist.interactor

import com.ae.mylibrary.common.dto.Character
import com.ae.mylibrary.common.dto.Info
import com.ae.mylibrary.common.dto.Location
import com.ae.mylibrary.common.dto.Origin
import com.ae.mylibrary.common.dto.Result
import com.ae.mylibrary.common.service.CharactersListService
import com.ae.mylibrary.entities.characterslist.presenter.CharactersListPresenter
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersListInteractorImplTest {

    @Mock
    private lateinit var service: CharactersListService

    @Mock
    private lateinit var interactor: CharactersListInteractor

    @Mock
    private lateinit var presenter: CharactersListPresenter

    private lateinit var character: Character
    private lateinit var episode: ArrayList<String>
    private lateinit var results: ArrayList<Result>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        episode = ArrayList()
        episode.add("Primer")

        results = ArrayList()
        results.add(Result("weqw", episode, "male"
            , 1, "url", Location("",""),
            "name", Origin("", ""), "specie", "status", "type", "uel"
        ))

        character = Character(
            Info(2, "next", 2, "prev"), results)

    }

    @Test
    fun shouldWhenFetchDataExist() {
        val observableResult = Observable.just(character)

        Mockito.`when`(service.getCharacterList()).thenReturn(observableResult)
        assertEquals(observableResult, service.getCharacterList())
    }

    @Test
    fun shouldWhenFetchDataIsSuccess() {
        interactor.successData(character.results)
        Mockito.verify(interactor).successData(character.results)

        presenter.successData(character.results)
        Mockito.verify(presenter).successData(character.results)
    }

}