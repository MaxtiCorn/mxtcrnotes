package com.maxticorn.mxtcrnotes

import android.app.Application
import com.maxticorn.mxtcrnotes.di.AppComponent
import com.maxticorn.mxtcrnotes.di.AppModule
import com.maxticorn.mxtcrnotes.di.DaggerAppComponent

class NotesApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}