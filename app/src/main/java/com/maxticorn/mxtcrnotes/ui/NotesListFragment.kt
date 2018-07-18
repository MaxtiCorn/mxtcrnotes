package com.maxticorn.mxtcrnotes.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.maxticorn.mxtcrnotes.R
import com.maxticorn.mxtcrnotes.domain.Note

class NotesListFragment : Fragment() {
    private lateinit var uiContainer: UiContainer
    private lateinit var rootView: View
    private lateinit var notesListViewModel: NotesListViewModel
    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var notesRecyclerViewAdapter: NotesRecyclerViewAdapter

    companion object {
        const val TAG = "NOTES_LIST_FRAGMENT"

        fun newInstance(): NotesListFragment {
            val fragment = NotesListFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is UiContainer) {
            uiContainer = context
        }
    }

    private fun subscribeUi() {
        notesListViewModel.notesLiveData.observe(this, Observer<List<Note>> {
            notesRecyclerViewAdapter.setNotes(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        notesListViewModel = ViewModelProviders.of(this)[NotesListViewModel::class.java]
        subscribeUi()
        setUpAddButton()
    }

    private fun setUpRecycler() {
        notesRecyclerView = rootView.findViewById(R.id.notes_list)
        notesRecyclerView.layoutManager = LinearLayoutManager(context)
        notesRecyclerViewAdapter = NotesRecyclerViewAdapter(uiContainer)
        notesRecyclerView.adapter = notesRecyclerViewAdapter
    }

    private fun setUpAddButton() {
        val addButton = rootView.findViewById<FloatingActionButton>(R.id.add_note_button)
        addButton.setOnClickListener {
            uiContainer.openNoteEdit(null)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_notes_list, container, false)
        setUpRecycler()
        return rootView
    }
}