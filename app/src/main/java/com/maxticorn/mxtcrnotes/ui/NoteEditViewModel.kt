package com.maxticorn.mxtcrnotes.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.maxticorn.mxtcrnotes.domain.Note

class NoteEditViewModel(app: Application, note: Note?) : AndroidViewModel(app) {
    val noteLiveData = MutableLiveData<Note>()

    init {
        noteLiveData.value = note
    }
}