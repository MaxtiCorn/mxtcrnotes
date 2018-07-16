package com.maxticorn.mxtcrnotes.ui

import com.maxticorn.mxtcrnotes.R
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.ui_layout, NotesListFragment.newInstance(), NotesListFragment.TAG)
            transaction.commit()
        }
    }
}