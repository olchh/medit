package com.example.myapplicationooooo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users")
data class user (
    @PrimaryKey(autoGenerate = true) //делает уникальные id
    var id: Int? =null,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "login")
    var login:String,
    @ColumnInfo(name = "password")
    var password:String,
    @ColumnInfo(name = "image")
    var image:String
)
