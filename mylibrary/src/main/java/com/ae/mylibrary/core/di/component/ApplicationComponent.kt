package com.ae.mylibrary.core.di.component

import com.ae.mylibrary.core.di.module.ApplicationModule
import com.ae.mylibrary.entities.characterslist.view.CharactersListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(charactersListActivity: CharactersListActivity)
}