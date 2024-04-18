package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentRazdelZaradkaBinding

class razdel_zaradka : Fragment() {
    private lateinit var binding : FragmentRazdelZaradkaBinding
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRazdelZaradkaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNaz4.setOnClickListener{
            MAIN.navController.navigate(R.id.action_razdel_zaradka_to_category)
        }

        binding.butRazZr1.setOnClickListener{
            val video = R.raw.videozr1
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr1)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr2.setOnClickListener{
            val video = R.raw.videozr2
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr2)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr3.setOnClickListener{
            val video = R.raw.videozr3
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr3)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr4.setOnClickListener{
            val video = R.raw.videozr4
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr4)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr5.setOnClickListener{
            val video = R.raw.videozr5
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr5)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr6.setOnClickListener{
            val video = R.raw.videozr6
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr6)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr7.setOnClickListener{
            val video = R.raw.videozr7
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr7)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }

        binding.butRazZr8.setOnClickListener{
            val video = R.raw.videozr8
            //подгружаем video
            bundle.putInt("patternVideo", video)


            val text = getString(R.string.textvideozr8)
            //подгружаем текст
            bundle.putString("patternVideoText", text)
            findNavController().navigate(R.id.action_razdel_zaradka_to_patternVideo, bundle)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            razdel_zaradka()
    }
}