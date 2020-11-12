package com.ex.noteappwithroom.data.repositories

import com.ex.noteappwithroom.data.Note
import com.ex.noteappwithroom.data.NoteDatabase

class NoteRepository(private val noteDatabase: NoteDatabase) {

    suspend fun insertNoteRepo(note : Note){
        noteDatabase.noteDao().addNoteDao(note)
    }

    suspend fun deleteNoteRepo(note: Note){
        noteDatabase.noteDao().deleteNoteDao(note)
    }

    fun getAllNotesRepo() = noteDatabase.noteDao().getAllNotesLists()
}