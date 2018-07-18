package com.maxticorn.mxtcrnotes.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maxticorn.mxtcrnotes.R
import com.maxticorn.mxtcrnotes.domain.Note

class MainActivity : AppCompatActivity(), UiContainer {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openNotesList()
        }
    }

    override fun openNotesList() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.ui_layout, NotesListFragment.newInstance(), NotesListFragment.TAG)
        transaction.commit()
    }

    override fun openNoteEdit(note: Note?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.ui_layout, NoteEditFragment.newInstance(note), NoteEditFragment.TAG)
        transaction.addToBackStack(NoteEditFragment.TAG)
        transaction.commit()
    }
}