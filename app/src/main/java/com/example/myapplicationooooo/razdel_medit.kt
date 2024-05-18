package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentRazdelMeditBinding

class razdel_medit : Fragment() {
    private lateinit var binding : FragmentRazdelMeditBinding
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRazdelMeditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNaz1.setOnClickListener{
            MAIN.navController.navigate(R.id.action_razdel_medit_to_category)
        }

        binding.butRazMe1.setOnClickListener{
            val music = 1
            //подгружаем music
            bundle.putInt("patternMedia", music)

            val image = R.drawable.memedia1
            //подгружаем картинку
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediame1)
            //подгружаем текст
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_razdel_medit_to_patternMedia, bundle)
        }

        binding.butRazMe2.setOnClickListener{
            val music = 2
            bundle.putInt("patternMedia", music)

            val image = R.drawable.memedia2
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediame2)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_razdel_medit_to_patternMedia, bundle)
        }

        binding.butRazMe3.setOnClickListener{
            val music = 3
            bundle.putInt("patternMedia", music)

            val image = R.drawable.memedia3
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediame3)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_razdel_medit_to_patternMedia, bundle)
        }

        binding.butRazMe4.setOnClickListener{
            val music = 4
            bundle.putInt("patternMedia", music)

            val image = R.drawable.memedia4
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediame4)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_razdel_medit_to_patternMedia, bundle)
        }

        binding.butRazMe5.setOnClickListener{
            val music = 5
            bundle.putInt("patternMedia", music)

            val image = R.drawable.memedia5
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediame5)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_razdel_medit_to_patternMedia, bundle)
        }

        binding.butRazMe6.setOnClickListener{
            val music = 6
            bundle.putInt("patternMedia", music)

            val image = R.drawable.memedia6
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediame6)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_razdel_medit_to_patternMedia, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            razdel_medit()

    }
}