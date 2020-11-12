package com.ex.noteappwithroom


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ex.noteappwithroom.adapter.NoteAdapter
import com.ex.noteappwithroom.data.Note
import com.ex.noteappwithroom.data.NoteDatabase
import com.ex.noteappwithroom.data.repositories.NoteRepository
import com.ex.noteappwithroom.viewmodel.NoteViewModel
import com.ex.noteappwithroom.viewmodel.NoteViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.InternalCoroutinesApi


class ListNotesActivity : AppCompatActivity() {



    private lateinit var noteAdapter: NoteAdapter

    private lateinit var note : List<Note>

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_notes)

        note = listOf()

        noteAdapter = note.let { NoteAdapter(this, it,
                noteViewModel = NoteViewModel(noteRepository = NoteRepository(noteDatabase = NoteDatabase.invoke(context = this)))) }


        Log.d("ListNotesActivity", "onCreate: Retreiving List")
        val recyclerView : RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = noteAdapter



      val viewModel = ViewModelProvider(this,
              NoteViewModelProvider(noteRepository = NoteRepository(noteDatabase = NoteDatabase.invoke(context = this)))).get(NoteViewModel::class.java)

        viewModel.getAllNotesViewModels().observe(this, Observer {
            noteAdapter.items = it
            noteAdapter.notifyDataSetChanged()
        })

        val fab : FloatingActionButton = findViewById(R.id.floatingActionButton)

        fab.setOnClickListener {
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }




    }
}