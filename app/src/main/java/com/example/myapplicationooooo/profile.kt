package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplicationooooo.databinding.FragmentProfileBinding
import org.json.JSONObject

class profile : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.butStutPr.setOnClickListener {
            MAIN.navController.navigate(R.id.action_profile_to_stat)
        }
        binding.butHomePr.setOnClickListener {
            MAIN.navController.navigate(R.id.action_profile_to_category)
        }

        //если в таблице ничего нет, то видим дефолтные значения и так же получение данных
        val jsonString = MAIN.pref?.getString("user", """
                                        {
                                            "user":{
                                                "name" : "имя",
                                                "login" : "логин"
                                            }
                                        }
                                        """)!!
        val mainObject = JSONObject(jsonString)


        binding.textprof1.text = mainObject.getJSONObject("user").getString("name")
        binding.textprof2.text = mainObject.getJSONObject("user").getString("login")
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            profile()
    }
}