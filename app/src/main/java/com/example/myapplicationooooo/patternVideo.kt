package com.example.myapplicationooooo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.myapplicationooooo.databinding.FragmentPatternVideoBinding
import com.example.myapplicationooooo.entity.MainDB
import com.example.myapplicationooooo.entity.VideoRecording

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

        val database = MainDB.getDB(MAIN)
        database.getDao().getAllvideoRecording().asLiveData().observe(MAIN){ list ->
            if(list.size == 0){
                VideoInit()
            }
        }

        binding.butPatternVideoDu.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternVideo_to_razdel_breath)
        }
        binding.butPatternVideoZr.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternVideo_to_razdel_zaradka)
        }

        try {
            val video = arguments?.getInt("patternVideo")
            database.getDao().getvideoRecirding(video).asLiveData().observe(MAIN) { list ->

                list.forEach { vidlist ->
                    if (video != null) {
                        val opi =
                            Uri.parse("android.resource://${MAIN.packageName}/${vidlist.video}")

                        binding.videoPattern.setVideoURI(opi)
                        binding.videoPattern.start()
                        binding.videoPattern.setMediaController(mediaController)
                        binding.videoPattern.requestFocus()
                        binding.videoPattern.pause()
                    }
                }
            }

            val text = arguments?.getString("patternVideoText")
            //подгружаем текст
            binding.textVideo.text = text
        }
        catch (e:Exception){
            Toast.makeText(MAIN, "error ${e}", Toast.LENGTH_SHORT).show()
        }
    }

    fun VideoInit(){
        try {
            val database = MainDB.getDB(MAIN)

            var videoList = listOf(
                VideoRecording(
                    null,
                    getString(R.string.textvideodu1),
                    R.raw.videodu1
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu2),
                    R.raw.videodu2
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu3),
                    R.raw.videodu3
                ),
                VideoRecording(
                    null,
                    getString(R.string.textmediame4),
                    R.raw.videodu4
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu5),
                    R.raw.videodu5
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu6),
                    R.raw.videodu6
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu7),
                    R.raw.videodu7
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu8),
                    R.raw.videodu8
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu9),
                    R.raw.videodu9
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideodu10),
                    R.raw.videodu10
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr1),
                    R.raw.videozr1
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr2),
                    R.raw.videozr2
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr3),
                    R.raw.videozr3
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr4),
                    R.raw.videozr4
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr5),
                    R.raw.videozr5
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr6),
                    R.raw.videozr6
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr7),
                    R.raw.videozr7
                ),
                VideoRecording(
                    null,
                    getString(R.string.textvideozr8),
                    R.raw.videozr8
                )
            )
            Thread { //создание нового потока
                for (i in 0..17) {
                    database.getDao().insertVideoRecording(videoList[i])
                }
            }.start()
        }
        catch (e:Exception){
            Toast.makeText(MAIN, "error ${e}", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            patternVideo()

    }
}