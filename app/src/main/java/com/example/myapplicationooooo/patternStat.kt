package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplicationooooo.databinding.FragmentPatternStatBinding


class patternStat : Fragment() {
    private lateinit var binding : FragmentPatternStatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatternStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.butPatternStatStat.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternStat_to_stat)
        }
        binding.butPatternStatHome.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternStat_to_category)
        }

        val text = arguments?.getString("patternStatText")
        //подгружаем текст
        binding.textStat.text = text

        val image = arguments?.getInt("patternStatImage")
        //подгружаем картинку
        if (image != null) {
            binding.imageStat.setImageResource(image.toInt())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            patternStat()
    }
}