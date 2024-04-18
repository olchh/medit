package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentRazdelUogaBinding

class razdel_uoga : Fragment() {


    private lateinit var binding : FragmentRazdelUogaBinding
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRazdelUogaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNaz2.setOnClickListener{
            MAIN.navController.navigate(R.id.action_uoga_to_category)
        }

        binding.butRazUo1.setOnClickListener{
            val music = R.raw.uo1
            //подгружаем music
            bundle.putInt("patternMedia", music)

            val image = R.drawable.uomedia1
            //подгружаем картинку
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediauo1)
            //подгружаем текст
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_uoga_to_patternMedia, bundle)
        }

        binding.butRazUo2.setOnClickListener{
            val music = R.raw.uo2
            bundle.putInt("patternMedia", music)

            val image = R.drawable.uomedia2
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediauo2)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_uoga_to_patternMedia, bundle)
        }

        binding.butRazUo3.setOnClickListener{
            val music = R.raw.uo3
            bundle.putInt("patternMedia", music)

            val image = R.drawable.uomedia3
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediauo3)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_uoga_to_patternMedia, bundle)
        }

        binding.butRazUo4.setOnClickListener{
            val music = R.raw.uo4
            bundle.putInt("patternMedia", music)

            val image = R.drawable.uomedia4
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediauo4)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_uoga_to_patternMedia, bundle)
        }

        binding.butRazUo5.setOnClickListener{
            val music = R.raw.uo5
            bundle.putInt("patternMedia", music)

            val image = R.drawable.uomedia5
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediauo5)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_uoga_to_patternMedia, bundle)
        }

        binding.butRazUo6.setOnClickListener{
            val music = R.raw.uo6
            bundle.putInt("patternMedia", music)

            val image = R.drawable.uomedia6
            bundle.putInt("patternMediaImage", image)

            val text = getString(R.string.textmediauo6)
            bundle.putString("patternMediaText", text)
            findNavController().navigate(R.id.action_uoga_to_patternMedia, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            razdel_uoga()

    }
}