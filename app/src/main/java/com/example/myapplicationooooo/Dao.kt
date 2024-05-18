package com.example.myapplicationooooo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplicationooooo.entity.AudioRecording
import com.example.myapplicationooooo.entity.Stati
import com.example.myapplicationooooo.entity.VideoRecording
import com.example.myapplicationooooo.entity.recommendation
import com.example.myapplicationooooo.entity.user
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertUser(user: user)//доавбление польз
    @Query("SELECT * FROM users")                //получение всех пользователей
    fun getAllUser(): Flow<List<user>>

    @Query("Update users set image = :image where id_user = :id") //изменение картинки
    fun updateUserImage(image:String, id:Int)

    @Query("Select * From users where id_user = :id")//получение списка пользлователей по условию
    fun getUser(id: Int): Flow<List<user>>


    @Insert
    fun insertRecommendation(recommendation: recommendation)//добавление рекомендации
    @Query("Select * From recommendation where id_rec = :id")                   //получение списка рекоммендаций по условию
    fun getRecommendation(id: Int): Flow<List<recommendation>>

    @Query("Select * From recommendation")                       //получение всех рекоммендаций
    fun getAllRecommendation(): Flow<List<recommendation>>


    @Insert
    fun insertStat(stat: Stati)//доавбление польз
    @Query("Select * From Stati where id_stat = :id") //получение списка рекоммендаций по условию
    fun getStat(id: Int?): Flow<List<Stati>>

    @Query("Select * From Stati")           //получение всех рекоммендаций
    fun getAllStat(): Flow<List<Stati>>



    @Insert
    fun insertVideoRecording(videoRecording: VideoRecording)//доавбление польз
    @Query("Select * From videoRecording where id_video = :id")             //получение списка рекоммендаций по условию
    fun getvideoRecirding(id: Int?): Flow<List<VideoRecording>>

    @Query("Select * From videoRecording")                      //получение всех рекоммендаций
    fun getAllvideoRecording(): Flow<List<VideoRecording>>


    @Insert
    fun insertAudioRecording(audioRecording: AudioRecording)//доавбление польз
    @Query("Select * From audioRecording where id_audio = :id")           //получение списка рекоммендаций по условию
    fun getaudioRecirding(id: Int?): Flow<List<AudioRecording>>

    @Query("Select * From audioRecording")                  //получение всех рекоммендаций
    fun getAllaudioRecording(): Flow<List<AudioRecording>>

}