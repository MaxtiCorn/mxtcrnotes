package com.maxticorn.mxtcrnotes.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.maxticorn.mxtcrnotes.domain.Note

class NotesListViewModel(application: Application) : AndroidViewModel(application) {
    val notesLiveData = MutableLiveData<List<Note>>()

    init {
        notesLiveData.postValue(null)
    }
}