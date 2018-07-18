package com.maxticorn.mxtcrnotes.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.maxticorn.mxtcrnotes.R
import com.maxticorn.mxtcrnotes.domain.Note

class NoteEditFragment : Fragment() {
    private lateinit var uiContainer: UiContainer
    private lateinit var viewModel: NoteEditViewModel
    private lateinit var rootView: View
    private lateinit var editTitle: EditText
    private lateinit var editContent: EditText

    companion object {
        const val TAG = "NOTE_EDIT_FRAGMENT"
        const val NOTE_KEY = "note"

        fun newInstance(note: Note?): NoteEditFragment {
            val fragment = NoteEditFragment()
            val args = Bundle()
            args.putParcelable(NOTE_KEY, note)
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
        viewModel.noteLiveData.observe(this, Observer<Note> {
            editTitle.setText(it?.title ?: "")
            editContent.setText(it?.content ?: "")
        }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,
                NoteEditViewModelFactory(activity!!.application, arguments?.getParcelable(NOTE_KEY)))[NoteEditViewModel::class.java]
        subscribeUi()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_note_edit, container, false)
        setUpButtons()
        return rootView
    }

    private fun setUpButtons() {
        editTitle = rootView.findViewById(R.id.edit_note_title)
        editContent = rootView.findViewById(R.id.edit_note_body)
        val okButton = rootView.findViewById<Button>(R.id.save_note_button)
        val cancelButton = rootView.findViewById<Button>(R.id.delete_note_button)
        okButton.setOnClickListener {
            viewModel.saveNote(editTitle.text.toString(), editContent.text.toString())
            uiContainer.openNotesList()
        }
        cancelButton.setOnClickListener {
            viewModel.deleteNote()
            uiContainer.openNotesList()
        }
    }
}