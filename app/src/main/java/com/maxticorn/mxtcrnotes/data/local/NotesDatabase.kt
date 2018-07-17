package com.maxticorn.mxtcrnotes.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.maxticorn.mxtcrnotes.domain.Note

@Database(version = NotesDatabase.DATABASE_VERSION,
        entities = [Note::class])
abstract class NotesDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "notes.db"
        const val DATABASE_VERSION = 1
    }

    abstract fun notesDao(): NotesDao
}