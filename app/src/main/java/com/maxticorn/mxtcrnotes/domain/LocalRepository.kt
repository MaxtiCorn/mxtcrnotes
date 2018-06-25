package com.maxticorn.mxtcrnotes.domain

import io.reactivex.Flowable

interface LocalRepository {
    fun getAllNotes(): Flowable<List<Note>>
    fun insertOrUpdate(notes: List<Note>)
    fun delete(notes: List<Note>)
}