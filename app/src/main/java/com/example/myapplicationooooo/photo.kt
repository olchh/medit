package com.example.myapplicationooooo

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import com.example.myapplicationooooo.databinding.FragmentPhotoBinding
import com.example.myapplicationooooo.entity.MainDB

class photo : Fragment() {
    private lateinit var binding : FragmentPhotoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val database = MainDB.getDB(MAIN)

        var id = arguments?.getInt("photoid")

        fun DataBasePhoto(image: String):String{
            var userString = ""
            database.getDao().getUser(id!!).asLiveData().observe(MAIN){list ->

                list.forEach{user ->
                     userString = """
                                        {
                                            "user":{
                                                "name" : "${user.name}",
                                                "login" : "${user.login}",
                                                "id" : "${user.id}",
                                                "image" : "${image}"
                                                
                                            }
                                        }
                                        """
                }


        }
            return userString


        }



        binding.icon1.setOnClickListener{
            database.getDao().updateUserImage("R.id.iconprof1", id!!)
            MAIN.deleteData()
            MAIN.saveData(DataBasePhoto("R.id.iconprof1"))

            MAIN.navController.navigate(R.id.action_profile_to_photo2)
    }
        binding.icon2.setOnClickListener{
            database.getDao().updateUserImage("R.id.iconprof1", id!!)
            MAIN.navController.navigate(R.id.action_profile_to_photo2)
        }
        binding.icon3.setOnClickListener{
            database.getDao().updateUserImage("R.id.iconprof1", id!!)
            MAIN.navController.navigate(R.id.action_profile_to_photo2)
        }
        binding.icon4.setOnClickListener{
            database.getDao().updateUserImage("R.id.iconprof1", id!!)
            MAIN.navController.navigate(R.id.action_profile_to_photo2)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            photo()
            }
    }
