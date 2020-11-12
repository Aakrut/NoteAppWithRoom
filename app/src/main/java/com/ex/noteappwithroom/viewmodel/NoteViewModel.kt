package com.ex.noteappwithroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex.noteappwithroom.data.Note
import com.ex.noteappwithroom.data.repositories.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(val noteRepository: NoteRepository) : ViewModel() {

    suspend fun insertNoteViewModel(note: Note){
       viewModelScope.launch {
           noteRepository.insertNoteRepo(note)
       }
    }

    suspend fun deleteNoteViewModel(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNoteRepo(note)
        }

    }

    fun getAllNotesViewModels() = noteRepository.getAllNotesRepo()
}