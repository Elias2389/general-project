package com.ae.mylibrary.core

import android.app.Application
import com.ae.mylibrary.core.di.component.ApplicationComponent
import com.ae.mylibrary.core.di.component.DaggerApplicationComponent
import com.ae.mylibrary.core.di.module.ApplicationModule

class BaseApplication: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

    }
}