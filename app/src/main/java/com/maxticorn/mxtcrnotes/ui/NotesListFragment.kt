package com.maxticorn.mxtcrnotes.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxticorn.mxtcrnotes.R
import com.maxticorn.mxtcrnotes.domain.Note

class NotesListFragment : Fragment() {
    private lateinit var rootView: View
    private lateinit var notesListViewModel: NotesListViewModel
    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var notesRecyclerViewAdapter: NotesRecyclerViewAdapter

    private fun subscribeUi() {
        notesListViewModel.notesLiveData.observe(this, Observer<List<Note>> {
            notesRecyclerViewAdapter.setNotes(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        notesListViewModel = ViewModelProviders.of(this)[NotesListViewModel::class.java]
        subscribeUi()
    }

    private fun setUpRecycler() {
        notesRecyclerView = rootView.findViewById(R.id.notes_list)
        notesRecyclerView.layoutManager = LinearLayoutManager(context)
        notesRecyclerViewAdapter = NotesRecyclerViewAdapter()
        notesRecyclerView.adapter = notesRecyclerViewAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_notes_list, container, false)
        setUpRecycler()
        return rootView
    }
}