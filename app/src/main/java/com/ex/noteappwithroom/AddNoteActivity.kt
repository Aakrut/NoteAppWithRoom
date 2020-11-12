package com.ex.noteappwithroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ex.noteappwithroom.data.Note
import com.ex.noteappwithroom.data.NoteDatabase
import com.ex.noteappwithroom.data.repositories.NoteRepository
import com.ex.noteappwithroom.viewmodel.NoteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {



    private lateinit var edit_t_title : EditText
    private lateinit var edit_t_task : EditText


    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)



        edit_t_title = findViewById(R.id.edit_text_title)
        edit_t_task = findViewById(R.id.edit_text_task)

        val button : Button = findViewById(R.id.button_save)
        button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO
            ) {
                val title_text : String = edit_t_title.text.toString()
                val task_text : String = edit_t_task.text.toString()

                if(title_text.isEmpty() || task_text.isEmpty()){
                    Toast.makeText(this@AddNoteActivity, "Please Fill all the Fields", Toast.LENGTH_SHORT).show()
                }else{
                    val note_t = Note(title_text,task_text)
                    NoteViewModel(noteRepository = NoteRepository(noteDatabase = NoteDatabase.invoke(this@AddNoteActivity))).insertNoteViewModel(note_t)
                    Log.d("AddNoteActivity", "onCreate: SuccessFully Added")
                    startActivity(Intent(this@AddNoteActivity,ListNotesActivity::class.java))
                    finish()
                }
            }
        }
    }



}