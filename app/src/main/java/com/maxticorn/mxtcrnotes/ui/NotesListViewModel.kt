package com.maxticorn.mxtcrnotes.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.maxticorn.mxtcrnotes.NotesApplication
import com.maxticorn.mxtcrnotes.domain.LoadNotesUseCase
import com.maxticorn.mxtcrnotes.domain.Note
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NotesListViewModel(application: Application) : AndroidViewModel(application) {
    val notesLiveData = MutableLiveData<List<Note>>()

    @Inject
    lateinit var loadNotesUseCase: LoadNotesUseCase

    init {
        (application as NotesApplication).appComponent.inject(this)
        notesLiveData.postValue(null)
        loadNotes()
    }

    private fun loadNotes() {
        notesLiveData.postValue(null)
        loadNotesUseCase.getAllNotes()
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    notesLiveData.postValue(it)
                }
    }
}