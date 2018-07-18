package com.maxticorn.mxtcrnotes.ui

import com.maxticorn.mxtcrnotes.domain.Note

interface UiContainer {
    fun openNoteEdit(note: Note?)
    fun openNotesList()
}