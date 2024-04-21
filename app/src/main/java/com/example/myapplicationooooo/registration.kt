package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.myapplicationooooo.databinding.FragmentRegistrationBinding
import com.example.myapplicationooooo.entity.MainDB
import com.example.myapplicationooooo.entity.user

class registration : Fragment() {

    private lateinit var binding : FragmentRegistrationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNazAuthor.setOnClickListener {
            MAIN.navController.navigate(R.id.action_registration_to_authorization)
        }

        binding.buttonRegistration.setOnClickListener{
            Registration()
            MAIN.navController.navigate(R.id.action_registration_to_authorization)

        }

    }

    private fun Registration(){

        val database = MainDB.getDB(MAIN)

        database.getDao().getAllUser().asLiveData().observe(MAIN){ list ->

            //list.forEach{userdata ->

                //if(binding.usLogin.text.toString() == userdata.login) {
                    //Toast.makeText(MAIN, "такой пользователь уже существует!", Toast.LENGTH_SHORT).show()
                    //return@forEach

               // }
                //else{
                    val us = user(null,
                        binding.usName.text.toString(),
                        binding.usLogin.text.toString(),
                        binding.usPassword.text.toString(),
                        "R.drawable.iconprof1")

                    Thread{ //создание нового потока
                        database.getDao().insertUser(us)
                    }.start()
                    //MAIN.navController.navigate(R.id.action_registration_to_authorization)
                    Toast.makeText(MAIN, "зарегистрирован пользователь ${binding.usName.text}", Toast.LENGTH_SHORT).show()


                }
            }
        //}
    //}

    companion object {
        @JvmStatic
        fun newInstance() =
            registration()
    }
}