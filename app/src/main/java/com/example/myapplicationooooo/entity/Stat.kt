package com.example.myapplicationooooo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stati")
data class Stati(
    @PrimaryKey(autoGenerate = true) //делает уникальные id
    var id_stat: Int? =null,
    @ColumnInfo(name = "imagestat")
    var imagestat:Int,
    @ColumnInfo(name = "contentstat")
    var contentstat:String
)
