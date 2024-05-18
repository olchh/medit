package com.example.myapplicationooooo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videoRecording")
data class VideoRecording(
    @PrimaryKey(autoGenerate = true)      //делает уникальные id
    var id_video: Int? =null,
    @ColumnInfo(name = "comment")
    var comment:String,
    @ColumnInfo(name = "video")
    var video:Int

)
