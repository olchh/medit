package com.example.myapplicationooooo

import android.content.res.Resources
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.myapplicationooooo.databinding.FragmentPatternMediaBinding

class patternMedia : Fragment() {
    private lateinit var binding : FragmentPatternMediaBinding
    private lateinit var mediaPlayer: MediaPlayer

    lateinit var runnable: Runnable
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatternMediaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.butPatternMediaMe.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternMedia_to_razdel_medit)
        }
        binding.butPatternMediaUo.setOnClickListener{
            MAIN.navController.navigate(R.id.action_patternMedia_to_uoga)
        }

        val colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
            Resources.getSystem().getColor(android.R.color.black, null),
            BlendModeCompat.SRC_ATOP
        )

        binding.seekBar.progressDrawable.colorFilter = colorFilter

        binding.seekBar.thumb.colorFilter = colorFilter
        //закrашивание передней и задней части полоски проигрывания

        val music = arguments?.getInt("patternMedia")
        if (music != null) {

            mediaPlayer = MediaPlayer.create(context,music)

        }
        val text = arguments?.getString("patternMediaText")
        //подгружаем текст
        binding.textMedia.text = text

        val image = arguments?.getInt("patternMediaImage")
        //подгружаем картинку
        if (image != null) {
            binding.imageMedia.setImageResource(image.toInt())
        }

        binding.seekBar.progress = 0
        binding.seekBar.max = mediaPlayer.duration

        binding.butPatMed.setOnClickListener{
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                binding.butPatMed.setImageResource(R.drawable.stop)
            }
            else{
                mediaPlayer.pause()
                binding.butPatMed.setImageResource(R.drawable.start)
            }
        }


        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            //воспроизведение с того места, куда пемемотали
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if(changed){
                    mediaPlayer.seekTo(pos)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        //отслеживание движения(если до конца, то нужно установить проигрывание)
        runnable = Runnable {
            binding.seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }

        //останавливает проигрывание и сбрасывает прогресс
        handler.postDelayed(runnable,1000)
        mediaPlayer.setOnCompletionListener {
            binding.butPatMed.setImageResource(R.drawable.start)
            binding.seekBar.progress = 0
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            patternMedia()

    }
}