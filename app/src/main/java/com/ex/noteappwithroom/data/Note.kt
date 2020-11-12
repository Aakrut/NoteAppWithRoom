package com.ex.noteappwithroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notedatabase")
data class Note(val title : String,val task : String) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}