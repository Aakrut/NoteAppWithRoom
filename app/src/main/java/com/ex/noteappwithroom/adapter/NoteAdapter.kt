package com.ex.noteappwithroom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ex.noteappwithroom.R
import com.ex.noteappwithroom.data.Note
import com.ex.noteappwithroom.data.NoteDatabase
import com.ex.noteappwithroom.data.repositories.NoteRepository
import com.ex.noteappwithroom.viewmodel.NoteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteAdapter(val context: Context,var items : List<Note>,private val noteViewModel: NoteViewModel) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
                val text_title : TextView = itemView.findViewById(R.id.title_text_item)
                val text_task : TextView = itemView.findViewById(R.id.task_text_item)
                val button_delete : Button = itemView.findViewById(R.id.button_remove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
      val current_item : Note = items[position]

        holder.text_title.text = current_item.title
        holder.text_task.text = current_item.task


        holder.button_delete.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO){
                 noteViewModel.deleteNoteViewModel(current_item)
            }
        }


    }

    override fun getItemCount(): Int {
            return items.size
    }


}