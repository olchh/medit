package com.example.myapplicationooooo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertUser(user: user)
    @Query("SELECT * FROM users")
    fun getAllUser(): Flow<List<user>>


}