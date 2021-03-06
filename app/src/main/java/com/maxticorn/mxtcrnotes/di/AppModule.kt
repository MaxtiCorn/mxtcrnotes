package com.maxticorn.mxtcrnotes.di

import android.arch.persistence.room.Room
import android.content.Context
import com.maxticorn.mxtcrnotes.data.local.LocalRepositoryImpl
import com.maxticorn.mxtcrnotes.data.local.NotesDao
import com.maxticorn.mxtcrnotes.data.local.NotesDatabase
import com.maxticorn.mxtcrnotes.domain.EditNotesUseCase
import com.maxticorn.mxtcrnotes.domain.LoadNotesUseCase
import com.maxticorn.mxtcrnotes.domain.LocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideNotesDatabase(): NotesDatabase {
        return Room.databaseBuilder(
                context,
                NotesDatabase::class.java,
                NotesDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(notesDatabase: NotesDatabase): NotesDao {
        return notesDatabase.notesDao()
    }

    @Provides
    @Singleton
    fun provideLocalRepository(notesDao: NotesDao): LocalRepository {
        return LocalRepositoryImpl(notesDao)
    }

    @Provides
    @Singleton
    fun provideLoadNotesUseCase(localRepository: LocalRepository): LoadNotesUseCase {
        return LoadNotesUseCase(localRepository)
    }

    @Provides
    @Singleton
    fun provideEditNotesUseCase(localRepository: LocalRepository): EditNotesUseCase {
        return EditNotesUseCase(localRepository)
    }
}