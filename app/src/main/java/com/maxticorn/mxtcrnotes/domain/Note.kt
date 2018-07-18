package com.maxticorn.mxtcrnotes.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.maxticorn.mxtcrnotes.data.local.NotesDao

@Entity(tableName = NotesDao.TABLE_NAME)
data class Note(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = NotesDao.Columns.ID) val id: Long?,
                @ColumnInfo(name = NotesDao.Columns.TITLE) var title: String?,
                @ColumnInfo(name = NotesDao.Columns.CONTENT) var content: String?) : Parcelable {
    @Ignore
    constructor() : this(null, null, null)

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id!!)
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}