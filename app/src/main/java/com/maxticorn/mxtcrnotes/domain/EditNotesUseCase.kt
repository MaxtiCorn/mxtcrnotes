package com.maxticorn.mxtcrnotes.domain

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class EditNotesUseCase(private val localRepository: LocalRepository) {
    fun addOrUpdateNotes(notes: List<Note>) {
        Observable.fromCallable {
            localRepository.insertOrUpdate(notes)
        }.subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun addOrUpdateNote(note: Note) {
        addOrUpdateNotes(listOf(note))
    }

    fun deleteNotes(notes: List<Note>) {
        Observable.fromCallable {
            localRepository.delete(notes)
        }.subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun deleteNote(note: Note) {
        deleteNotes(listOf(note))
    }
}