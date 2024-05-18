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
            //MAIN.navController.navigate(R.id.action_registration_to_authorization)
        }
    }

    private fun Registration() {
        try {
            if (EmptyFields()) {
                if (SpecialCharacter()) {

                    val database = MainDB.getDB(MAIN)
                    var count = 0

                    database.getDao().getAllUser().asLiveData().observe(MAIN) { list ->
                        if (list.size == 0) {
                            val us = user(
                                null,
                                binding.usName.text.toString(),
                                binding.usSurname.text.toString(),
                                Integer.parseInt(binding.usAge.text.toString().trim()),
                                binding.usLogin.text.toString(),
                                binding.usPassword.text.toString(),
                                "R.drawable.iconprof1"
                            )

                            Thread { //создание нового потока
                                database.getDao().insertUser(us)
                            }.start()

                            Toast.makeText(
                                MAIN, "зарегистрирован пользователь ${binding.usName.text}",
                                Toast.LENGTH_SHORT
                            ).show()
                            MAIN.navController.navigate(R.id.action_registration_to_authorization)

                        } else {

                            list.forEach { userdata ->

                                if (binding.usLogin.text.toString() == userdata.login) {

                                    count = 1
                                    return@forEach

                                }

                            }
                            if (count == 1) {
                                Toast.makeText(
                                    MAIN,
                                    "такой пользователь уже существует!",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()

                            }
                            if (count == 0) {
                                val us = user(
                                    null,
                                    binding.usName.text.toString(),
                                    binding.usSurname.text.toString(),
                                    Integer.parseInt(binding.usAge.text.toString().trim()),
                                    binding.usLogin.text.toString(),
                                    binding.usPassword.text.toString(),
                                    "R.drawable.iconprof1"
                                )

                                Thread { //создание нового потока
                                    database.getDao().insertUser(us)
                                }.start()

                                Toast.makeText(
                                    MAIN, "зарегистрирован пользователь ${binding.usName.text}",
                                    Toast.LENGTH_SHORT
                                ).show()
                                MAIN.navController.navigate(R.id.action_registration_to_authorization)
                            }
                        }
                    }
                }
            }
        }
        catch (e:Exception){
            Toast.makeText(MAIN, "error ${e}", Toast.LENGTH_SHORT).show()
        }
    }
    private fun EmptyFields(): Boolean {
        if (binding.usSurname.text.toString() == "" ||
            binding.usName.text.toString() == "" ||
            binding.usAge.text.toString() == "" ||
            binding.usLogin.text.toString() == "" ||
            binding.usPassword.text.toString() == "") {
            Toast.makeText(MAIN, "заполнены не все поля", Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            return true
        }
    }
    private fun SpecialCharacter(): Boolean {
        val pattern = Regex(".*[/^1-9\\d!@#\$%^&*()_\\-=+\\\\|[\\]{}:;.,<>?]+\$/].*")
        if(pattern.matches(binding.usSurname.text.toString()) || pattern.matches(binding.usName.text.toString())) {
            Toast.makeText(MAIN, "вы ввели спецсимволы или цифры в имени или фамилии", Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            return true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            registration()
    }
}