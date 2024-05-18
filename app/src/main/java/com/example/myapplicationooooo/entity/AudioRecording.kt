package com.example.myapplicationooooo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audioRecording")
data class AudioRecording(
    @PrimaryKey(autoGenerate = true) //делает уникальные id
    var id_audio: Int? =null,
    @ColumnInfo(name = "imageaudio")
    var imageaudio:Int,
    @ColumnInfo(name = "comment")
    var comment:String,
    @ColumnInfo(name = "audio")
    var audio:Int
)
