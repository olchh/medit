package com.example.myapplicationooooo

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentProfileBinding
import com.example.myapplicationooooo.entity.MainDB
import com.example.myapplicationooooo.entity.recommendation
import com.example.myapplicationooooo.entity.user
import org.json.JSONObject

class profile : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        //если в таблице ничего нет, то видим дефолтные значения и так же получение данных
        val jsonString = MAIN.pref?.getString("user", """
                                        {
                                            "user":{
                                                "name" : "имя",
                                                "surname" : "фамилия",
                                                "age" : "возраст",
                                                "login" : "логин",
                                                "id" : "1",
                                                "image" : "R.drawable.iconprof1"
                                            }
                                        }
                                        """)!!
        val mainObject = JSONObject(jsonString)

        binding.textprofName.text = mainObject.getJSONObject("user").getString("name")
        binding.textprofFam.text = mainObject.getJSONObject("user").getString("surname")
        binding.textprofAge.text = mainObject.getJSONObject("user").getString("age")
        binding.textprofLogin.text = mainObject.getJSONObject("user").getString("login")

        val id = mainObject.getJSONObject("user").getInt("id")

        binding.butStutPr.setOnClickListener {
            MAIN.navController.navigate(R.id.action_profile_to_stat)
        }
        binding.butHomePr.setOnClickListener {
            MAIN.navController.navigate(R.id.action_profile_to_category)
        }
        binding.imageButtonIcon.setOnClickListener {
            bundle.putInt("photoid", id)
            findNavController().navigate(R.id.action_profile_to_photo2, bundle)
        }

        val database = MainDB.getDB(MAIN)
        database.getDao().getAllRecommendation().asLiveData().observe(MAIN){ list ->
            if(list.size == 0){
                RecInit()
            }
        }
        RecComletion(mainObject.getJSONObject("user").getInt("age"))
    }
    fun RecInit(){
        val database = MainDB.getDB(MAIN)

        var recList = listOf(
            recommendation(
                null,
                getString(R.string.rec1)
            ),
            recommendation(
                null,
                getString(R.string.rec2)
            ),
            recommendation(
                null,
                getString(R.string.rec3)
            )
        )
        Thread { //создание нового потока
            for (i in 0..2) {
                database.getDao().insertRecommendation(recList[i])
            }
        }.start()

    }
    fun RecComletion(age:Int){
        val database = MainDB.getDB(MAIN)
        if (age>0 && age <19){
            database.getDao().getRecommendation(1).asLiveData().observe(MAIN){list ->

                list.forEach{reclist ->
                    binding.textprofRec.text = reclist.contentrec
                }
            }
        }
        if (age>18 && age <40){
            database.getDao().getRecommendation(2).asLiveData().observe(MAIN){list ->

                list.forEach{reclist ->
                    binding.textprofRec.text = reclist.contentrec
                }
            }
        }
        if (age>39 && age <100){
            database.getDao().getRecommendation(3).asLiveData().observe(MAIN){list ->

                list.forEach{reclist ->
                    binding.textprofRec.text = reclist.contentrec
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            profile()
    }
}