package com.maxticorn.mxtcrnotes.data.remote

import com.maxticorn.mxtcrnotes.domain.Note
import com.maxticorn.mxtcrnotes.domain.RemoteRepository
import io.reactivex.Single

class RemoteRepositoryImpl(private val notesAPI: NotesAPI) : RemoteRepository {
    override fun getAllNotes(): Single<List<Note>> = notesAPI.getAllNotes()
}