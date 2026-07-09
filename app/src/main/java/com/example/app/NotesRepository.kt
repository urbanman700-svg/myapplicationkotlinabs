package com.example.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesRepository {
    private val notes = mutableListOf<Note>()
    private val notesLiveData = MutableLiveData<List<Note>>()

    fun addNote(note: Note) {
        notes.add(note)
        notesLiveData.value = notes
    }

    fun getNotes(): MutableLiveData<List<Note>> {
        return notesLiveData
    }
}