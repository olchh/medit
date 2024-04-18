package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.myapplicationooooo.databinding.FragmentAuthorizationBinding
import com.example.myapplicationooooo.entity.MainDB

class authorization : Fragment() {
    private lateinit var binding : FragmentAuthorizationBinding

    val bundle = Bundle()

    var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNazRegist.setOnClickListener {
            MAIN.navController.navigate(R.id.action_authorization_to_registration)
        }

        binding.buttonAuthorization.setOnClickListener {
            Autorization()



        }

    }

    private fun Autorization(){
        val database = MainDB.getDB(MAIN)
        database.getDao().getAllUser().asLiveData().observe(MAIN){ list ->

            list.forEach{user ->

                if(binding.usLoginA.text.toString() == user.login){

                    if(binding.usPassA.text.toString() == user.password){


                        var userString = """
                                        {
                                            "user":{
                                                "name" : "${user.name}",
                                                "login" : "${user.login}"
                                            }
                                        }
                                        """

                        MAIN.saveData(userString)
                        MAIN.navController.navigate(R.id.action_authorization_to_category)

                        count = 1
                        Toast.makeText(MAIN, "Пользователь: ${user.name} авторизирован", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if (count == 0){
                Toast.makeText(MAIN, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }

    }



    companion object {
        @JvmStatic
        fun newInstance() =
            authorization()

    }
}