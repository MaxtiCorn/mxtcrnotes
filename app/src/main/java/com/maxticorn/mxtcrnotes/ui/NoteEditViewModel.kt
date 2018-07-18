package com.maxticorn.mxtcrnotes.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.maxticorn.mxtcrnotes.NotesApplication
import com.maxticorn.mxtcrnotes.domain.EditNotesUseCase
import com.maxticorn.mxtcrnotes.domain.Note
import javax.inject.Inject

class NoteEditViewModel(application: Application, note: Note?) : AndroidViewModel(application) {
    val noteLiveData = MutableLiveData<Note>()

    @Inject
    lateinit var editNotesUseCase: EditNotesUseCase

    init {
        (application as NotesApplication).appComponent.inject(this)
        noteLiveData.postValue(note)
    }

    fun saveNote(title: String, content: String) {
        val note = Note(null, title, content)
        editNotesUseCase.addOrUpdateNote(note)
    }

    fun deleteNote() {
        val note = noteLiveData.value
        if (note != null) {
            editNotesUseCase.deleteNote(note)
        }
    }
}