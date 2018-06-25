package com.maxticorn.mxtcrnotes.domain

import io.reactivex.Flowable

class LoadNotesUseCase(private val localRepository: LocalRepository) {
    fun getAllNotes(): Flowable<List<Note>> {
        return localRepository.getAllNotes()
    }
}