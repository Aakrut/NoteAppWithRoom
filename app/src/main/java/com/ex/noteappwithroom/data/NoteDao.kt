package com.ex.noteappwithroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNoteDao(note: Note)

    @Delete
   suspend fun deleteNoteDao(note: Note)

    @Query("SELECT * FROM notedatabase")
    fun getAllNotesLists() : LiveData<List<Note>>

}