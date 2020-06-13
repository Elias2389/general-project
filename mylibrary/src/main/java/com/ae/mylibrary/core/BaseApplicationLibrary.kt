package com.ae.mylibrary.core

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.ae.mylibrary.core.di.component.ApplicationComponent
import com.ae.mylibrary.core.di.component.DaggerApplicationComponent
import com.ae.mylibrary.core.di.module.ApplicationModule

class BaseApplicationLibrary: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

    }

    fun getComponent(): DaggerApplicationComponent {
        return component as DaggerApplicationComponent
    }
}