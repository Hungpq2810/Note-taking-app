package com.example.notetakingapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.repository.NoteRepository

class NoteViewModel(
    app: Application,
    private val noteRepository: NoteRepository
) : AndroidViewModel(app) {

    suspend fun insert(note: Note) {
        noteRepository.insertNote(note)
    }

    suspend fun update(note: Note) {
        noteRepository.updateNote(note)
    }

    suspend fun delete(note: Note) {
        noteRepository.deleteNote(note)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }

    fun searchNotes(query: String?): LiveData<List<Note>> {
        return noteRepository.searchNotes(query)
    }


}