package com.ex.noteappwithroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ex.noteappwithroom.data.repositories.NoteRepository

@Suppress("UNCHECKED_CAST")
class NoteViewModelProvider(private val noteRepository : NoteRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(noteRepository) as T
    }
}