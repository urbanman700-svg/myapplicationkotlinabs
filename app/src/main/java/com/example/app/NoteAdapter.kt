package com.example.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NoteAdapter(context: Context, var notes: List<Note>) : ArrayAdapter<Note>(context, 0, notes) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val note = notes[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)

        val titleTextView: TextView = view.findViewById(R.id.title)
        titleTextView.text = note.title

        val contentTextView: TextView = view.findViewById(R.id.content)
        contentTextView.text = note.content

        return view
    }
}