package com.example.myapplicationooooo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplicationooooo.entity.user
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertUser(user: user)
    @Query("SELECT * FROM users")
    fun getAllUser(): Flow<List<user>>

    @Query("Update users set image = :image where id = :id")
    fun updateUserImage(image:String, id:Int)

    @Query("Select * From users where id = :id")
    fun getUser(id: Int): Flow<List<user>>
}