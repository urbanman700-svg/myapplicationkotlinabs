package com.example.app

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private lateinit var notesRepository: NotesRepository
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRepository = NotesRepository()
        noteAdapter = NoteAdapter(this, notesRepository.getNotes().value ?: emptyList())

        val listView: ListView = findViewById(R.id.notes_list)
        listView.adapter = noteAdapter

        notesRepository.getNotes().observe(this, Observer { notes ->
            noteAdapter.notes = notes
            noteAdapter.notifyDataSetChanged()
        })
    }
}