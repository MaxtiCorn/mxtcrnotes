package com.maxticorn.mxtcrnotes.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.maxticorn.mxtcrnotes.data.local.NotesDao

@Entity(tableName = NotesDao.TABLE_NAME,
        primaryKeys = [NotesDao.Columns.ID])
data class Note(@ColumnInfo(name = NotesDao.Columns.ID) val id: Long,
                @ColumnInfo(name = NotesDao.Columns.TITLE) val title: String,
                @ColumnInfo(name = NotesDao.Columns.CONTENT) val content: String)