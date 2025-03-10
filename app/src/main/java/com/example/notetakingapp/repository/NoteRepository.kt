package com.example.notetakingapp.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.notetakingapp.db.NoteDatabase
import com.example.notetakingapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

        suspend fun insertNote(note: Note) {
            db.noteDao().insertNote(note)
        }

        suspend fun updateNote(note: Note) {
            db.noteDao().updateNote(note)
        }

        suspend fun deleteNote(note: Note) {
            db.noteDao().deleteNote(note)
        }

        fun getAllNotes(): LiveData<List<Note>> {
            return db.noteDao().getAllNotes()
        }

        fun searchNotes(query: String?): LiveData<List<Note>> {
            return db.noteDao().searchNotes(query)
        }


}