package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentRazdelBreathBinding


class razdel_breath : Fragment() {
    private lateinit var binding : FragmentRazdelBreathBinding

    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRazdelBreathBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNaz3.setOnClickListener{
            MAIN.navController.navigate(R.id.action_razdel_breath_to_category)
        }

        binding.buttonRazdelBreath1.setOnClickListener{
            val video = 1
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideodu1)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath2.setOnClickListener{
            val video = 2
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideodu2)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath3.setOnClickListener{
            val video = 3
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideodu3)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath4.setOnClickListener{
            val video = 4
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideodu4)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath5.setOnClickListener{
            val video = 5
            //подгружаем video
            bundle.putInt("patternVideo", video)

            val text = getString(R.string.textvideodu5)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath6.setOnClickListener{
            val video = 6
            //подгружаем video
            bundle.putInt("patternVideo", video)

            val text = getString(R.string.textvideodu6)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath7.setOnClickListener{
            val video = 7
            //подгружаем video
            bundle.putInt("patternVideo", video)

            val text = getString(R.string.textvideodu7)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath8.setOnClickListener{
            val video = 8
            //подгружаем video
            bundle.putInt("patternVideo", video)

            val text = getString(R.string.textvideodu8)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath9.setOnClickListener{
            val video = 9
            //подгружаем video
            bundle.putInt("patternVideo", video)

            val text = getString(R.string.textvideodu9)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }

        binding.buttonRazdelBreath10.setOnClickListener{
            val video = 10
            //подгружаем video
            bundle.putInt("patternVideo", video)

            val text = getString(R.string.textvideodu10)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_breath_to_patternVideo, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            razdel_breath()
    }
}