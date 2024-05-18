package com.example.myapplicationooooo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recommendation")
data class recommendation(
    @PrimaryKey(autoGenerate = true)             //делает уникальные id
    var id_rec: Int? =null,
    @ColumnInfo(name = "contentrec")
    var contentrec:String
)



