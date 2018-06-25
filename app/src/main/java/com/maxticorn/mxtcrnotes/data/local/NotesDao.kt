package com.maxticorn.mxtcrnotes.data.local

import android.arch.persistence.room.*
import com.maxticorn.mxtcrnotes.domain.Note
import io.reactivex.Flowable

@Dao
interface NotesDao {
    companion object {
        const val TABLE_NAME = "notes"
    }

    interface Columns {
        companion object {
            const val ID = "id"
            const val TITLE = "title"
            const val CONTENT = "content"
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(notes: List<Note>)

    @Delete
    fun delete(notes: List<Note>)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllNotes(): Flowable<List<Note>>
}