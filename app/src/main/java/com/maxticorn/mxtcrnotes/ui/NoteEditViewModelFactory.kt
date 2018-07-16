package com.maxticorn.mxtcrnotes.ui

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.maxticorn.mxtcrnotes.domain.Note

class NoteEditViewModelFactory(private val application: Application, private val note: Note?) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteEditViewModel(application, note) as T
    }
}