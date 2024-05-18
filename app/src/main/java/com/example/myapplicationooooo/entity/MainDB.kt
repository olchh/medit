package com.example.myapplicationooooo.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplicationooooo.Dao
import com.example.myapplicationooooo.stat

@Database(entities = [user::class, recommendation::class, Stati::class, VideoRecording::class, AudioRecording::class], version = 1)
abstract class MainDB : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        fun getDB(context:Context) : MainDB{
                          //функция для создания бд
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "medit"
            ).build()
        }
    }
}