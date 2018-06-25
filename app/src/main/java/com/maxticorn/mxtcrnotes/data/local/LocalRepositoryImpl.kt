package com.maxticorn.mxtcrnotes.data.local

import com.maxticorn.mxtcrnotes.domain.LocalRepository
import com.maxticorn.mxtcrnotes.domain.Note

class LocalRepositoryImpl(private val notesDao: NotesDao) : LocalRepository {
    override fun getAllNotes() = notesDao.getAllNotes()

    override fun insertOrUpdate(notes: List<Note>) = notesDao.insertOrUpdate(notes)

    override fun delete(notes: List<Note>) = notesDao.delete(notes)
}