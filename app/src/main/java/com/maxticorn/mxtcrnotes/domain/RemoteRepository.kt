package com.maxticorn.mxtcrnotes.domain

import io.reactivex.Single

interface RemoteRepository {
    fun getAllNotes(): Single<List<Note>>
}