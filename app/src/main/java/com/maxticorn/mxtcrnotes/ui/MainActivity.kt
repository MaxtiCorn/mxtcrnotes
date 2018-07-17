package com.maxticorn.mxtcrnotes.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maxticorn.mxtcrnotes.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.ui_layout, NotesListFragment.newInstance(), NotesListFragment.TAG)
            transaction.commit()
        }
    }
}