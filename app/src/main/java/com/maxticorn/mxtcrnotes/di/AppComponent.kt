package com.maxticorn.mxtcrnotes.di

import com.maxticorn.mxtcrnotes.ui.NotesListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(notesListViewModel: NotesListViewModel)
}