package com.example.myapplicationooooo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import com.example.myapplicationooooo.databinding.FragmentPatternVideoBinding

class patternVideo : Fragment() {

    private lateinit var binding : FragmentPatternVideoBinding


    val bundle = Bundle()

    val mediaController = MediaController(MAIN)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatternVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.butPatternVideoDu.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternVideo_to_razdel_breath)
        }
        binding.butPatternVideoZr.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternVideo_to_razdel_zaradka)
        }

        val video = arguments?.getInt("patternVideo")
        if (video != null) {
            //val uri = Uri.parse("android.resource://$packageN")
            val opi = Uri.parse("android.resource://${MAIN.packageName}/${video}")

            binding.videoPattern.setVideoURI(opi)
            binding.videoPattern.start()
            binding.videoPattern.setMediaController(mediaController)
            binding.videoPattern.requestFocus()
            binding.videoPattern.pause()
        }

        val text = arguments?.getString("patternVideoText")
        //подгружаем текст
        binding.textVideo.text = text
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            patternVideo()

    }
}