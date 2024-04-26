package com.example.myapplicationooooo

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentProfileBinding
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
                                                "login" : "логин",
                                                "id" : "1",
                                                "image" : "R.drawable.iconprof1"
                                            }
                                        }
                                        """)!!
        val mainObject = JSONObject(jsonString)



        binding.textprofName.text = mainObject.getJSONObject("user").getString("name")
        binding.textprofLogin.text = mainObject.getJSONObject("user").getString("login")

        val drawableId: Int = resources.getIdentifier(mainObject.getJSONObject("user").getString("image"), "drawable", "res")
        //val drawable: Drawable? = ContextCompat.getDrawable(MAIN, drawableId)
        binding.imageButtonIcon.setBackgroundResource(drawableId)


        binding.butStutPr.setOnClickListener {
            MAIN.navController.navigate(R.id.action_profile_to_stat)
        }
        binding.butHomePr.setOnClickListener {
            MAIN.navController.navigate(R.id.action_profile_to_category)
        }
        binding.imageButtonIcon.setOnClickListener {
            val image = R.drawable.iconprof1
            bundle.putInt("photoid", image)
            findNavController().navigate(R.id.action_profile_to_photo2, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            profile()
    }
}