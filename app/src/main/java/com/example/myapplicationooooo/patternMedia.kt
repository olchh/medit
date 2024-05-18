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
import android.widget.Toast
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.lifecycle.asLiveData
import com.example.myapplicationooooo.databinding.FragmentPatternMediaBinding
import com.example.myapplicationooooo.entity.AudioRecording
import com.example.myapplicationooooo.entity.MainDB

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

        val database = MainDB.getDB(MAIN)
        database.getDao().getAllaudioRecording().asLiveData().observe(MAIN){ list ->
            if(list.size == 0){
                MediaInit()
            }
        }

        val colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
            Resources.getSystem().getColor(android.R.color.black, null),
            BlendModeCompat.SRC_ATOP
        )

        binding.seekBar.progressDrawable.colorFilter = colorFilter

        binding.seekBar.thumb.colorFilter = colorFilter
        //закrашивание передней и задней части полоски проигрывания

        val music = arguments?.getInt("patternMedia", 1)

        try {
            database.getDao().getaudioRecirding(music).asLiveData().observe(MAIN) { list ->

                list.forEach { audlist ->
                    if (music != null) {
                        mediaPlayer = MediaPlayer.create(context, audlist.audio)
                    }
                    if (audlist.imageaudio != null) {
                        binding.imageMedia.setImageResource(audlist.imageaudio)
                    }
                    binding.textMedia.text = audlist.comment
                }

                binding.seekBar.progress = 0
                binding.seekBar.max = mediaPlayer.duration

                binding.butPatMed.setOnClickListener {
                    if (!mediaPlayer.isPlaying) {
                        mediaPlayer.start()
                        binding.butPatMed.setImageResource(R.drawable.stop)
                    } else {
                        mediaPlayer.pause()
                        binding.butPatMed.setImageResource(R.drawable.start)
                    }
                }

                binding.seekBar.setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    //воспроизведение с того места, куда пемемотали
                    override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                        if (changed) {
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
                    handler.postDelayed(runnable, 1000)
                }

                //останавливает проигрывание и сбрасывает прогресс
                handler.postDelayed(runnable, 1000)
                mediaPlayer.setOnCompletionListener {
                    binding.butPatMed.setImageResource(R.drawable.start)
                    binding.seekBar.progress = 0
                }

                binding.butPatternMediaMe.setOnClickListener {
                    mediaPlayer.pause()
                    MAIN.navController.navigate(R.id.action_patternMedia_to_razdel_medit)
                }
                binding.butPatternMediaUo.setOnClickListener {
                    mediaPlayer.pause()
                    MAIN.navController.navigate(R.id.action_patternMedia_to_uoga)
                }
            }
        }
        catch (e:Exception){
            Toast.makeText(MAIN, "error ${e}", Toast.LENGTH_SHORT).show()
        }

    }
    fun MediaInit(){
        try {
            val database = MainDB.getDB(MAIN)

            var audioList = listOf(
                AudioRecording(
                    null,
                    R.drawable.memedia1,
                    getString(R.string.textmediame1),
                    R.raw.binaur_1
                ),
                AudioRecording(
                    null,
                    R.drawable.memedia2,
                    getString(R.string.textmediame2),
                    R.raw.binaur_2
                ),
                AudioRecording(
                    null,
                    R.drawable.memedia3,
                    getString(R.string.textmediame3),
                    R.raw.giper_1
                ),
                AudioRecording(
                    null,
                    R.drawable.memedia4,
                    getString(R.string.textmediame4),
                    R.raw.giper_2
                ),
                AudioRecording(
                    null,
                    R.drawable.memedia5,
                    getString(R.string.textmediame5),
                    R.raw.otk_cosmos
                ),
                AudioRecording(
                    null,
                    R.drawable.memedia6,
                    getString(R.string.textmediame6),
                    R.raw.cosmos
                ),
                AudioRecording(
                    null,
                    R.drawable.uomedia1,
                    getString(R.string.textmediauo1),
                    R.raw.uo1
                ),
                AudioRecording(
                    null,
                    R.drawable.uomedia2,
                    getString(R.string.textmediauo2),
                    R.raw.uo2
                ),
                AudioRecording(
                    null,
                    R.drawable.uomedia3,
                    getString(R.string.textmediauo3),
                    R.raw.uo3
                ),
                AudioRecording(
                    null,
                    R.drawable.uomedia4,
                    getString(R.string.textmediauo4),
                    R.raw.uo4
                ),
                AudioRecording(
                    null,
                    R.drawable.uomedia5,
                    getString(R.string.textmediauo5),
                    R.raw.uo5
                ),
                AudioRecording(
                    null,
                    R.drawable.uomedia6,
                    getString(R.string.textmediauo5),
                    R.raw.uo6
                )

            )
            Thread { //создание нового потока
                for (i in 0..11) {
                    database.getDao().insertAudioRecording(audioList[i])
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
            patternMedia()

    }
}