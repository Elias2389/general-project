package com.ae.mylibrary.common.service

import com.ae.mylibrary.common.dto.Character
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface CharactersListService {
    @GET("character/")
    fun getCharacterList(): Observable<Character>
}