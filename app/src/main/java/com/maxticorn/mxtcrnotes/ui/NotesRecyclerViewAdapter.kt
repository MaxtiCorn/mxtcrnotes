package com.maxticorn.mxtcrnotes.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.maxticorn.mxtcrnotes.R
import com.maxticorn.mxtcrnotes.domain.Note

class NotesRecyclerViewAdapter : RecyclerView.Adapter<NotesRecyclerViewAdapter.NoteViewHolder>() {
    private var notes: List<Note>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes?.size ?: 0

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes?.get(position)
        if (note != null) {
            holder.title.text = note.title
            holder.content.text = note.content
        }
    }

    fun setNotes(notes: List<Note>?) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.note_title)
        var content: TextView = view.findViewById(R.id.note_content)
    }
}