package com.maxticorn.mxtcrnotes.data.remote

import com.maxticorn.mxtcrnotes.domain.Note
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface NotesAPI {
    companion object {
        val BASE_URL: String = "http://notes.mrdekk.ru"
    }

    @GET("/notes")
    fun getAllNotes(): Single<List<Note>>

    @GET("/notes/{uid}")
    fun getNote(@Path("uid") uid: String): Single<Note>

    @POST("/notes")
    fun createNote(@Body() note: Note): Single<Note>

    @Multipart
    @PUT("/notes/{uid}")
    fun editNote(@Path("uid") uid: String, @Body() note: Note): Single<Note>

    @DELETE("/notes/{uid}")
    fun deleteNote(@Path("uid") uid: String): Single<Note>
}