package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.myapplicationooooo.databinding.FragmentPatternStatBinding
import com.example.myapplicationooooo.entity.MainDB
import com.example.myapplicationooooo.entity.Stati


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

        val database = MainDB.getDB(MAIN)
        database.getDao().getAllStat().asLiveData().observe(MAIN){ list ->
            if(list.size == 0){
                StatInit()
            }
        }

        try {
            val statId = arguments?.getInt("patternStatId", 1)

            database.getDao().getStat(statId).asLiveData().observe(MAIN) { list ->

                list.forEach { reclist ->
                    binding.textStat.text = reclist.contentstat
                    if (reclist.imagestat != null) {
                        binding.imageStat.setImageResource(reclist.imagestat)
                    }
                }
            }
        }
        catch (e:Exception){
            Toast.makeText(MAIN, "error ${e}", Toast.LENGTH_SHORT).show()
        }
    }
    fun StatInit(){
        try {
            val database = MainDB.getDB(MAIN)

            var statList = listOf(
                Stati(
                    null,
                    R.drawable.mestos1,
                    getString(R.string.statme)
                ),
                Stati(
                    null,
                    R.drawable.mestat1,
                    getString(R.string.statme1)
                ),
                Stati(
                    null,
                    R.drawable.mestat2,
                    getString(R.string.statme2)
                ),
                Stati(
                    null,
                    R.drawable.mestat3,
                    getString(R.string.statme3)
                ),
                Stati(
                    null,
                    R.drawable.mestat4,
                    getString(R.string.statme4)
                ),
                Stati(
                    null,
                    R.drawable.uostos1,
                    getString(R.string.statuo)
                ),
                Stati(
                    null,
                    R.drawable.mestat5,
                    getString(R.string.statuo1)
                ),
                Stati(
                    null,
                    R.drawable.mestat6,
                    getString(R.string.statuo2)
                ),
                Stati(
                    null,
                    R.drawable.mestat7,
                    getString(R.string.statuo3)
                ),
                Stati(
                    null,
                    R.drawable.mestat8,
                    getString(R.string.statuo4)
                ),
                Stati(
                    null,
                    R.drawable.dustos1,
                    getString(R.string.statdu)
                ),
                Stati(
                    null,
                    R.drawable.mestat9,
                    getString(R.string.statdu1)
                ),
                Stati(
                    null,
                    R.drawable.mestat10,
                    getString(R.string.statdu2)
                ),
                Stati(
                    null,
                    R.drawable.mestat11,
                    getString(R.string.statdu3)
                ),
                Stati(
                    null,
                    R.drawable.mestat12,
                    getString(R.string.statdu4)
                ),
                Stati(
                    null,
                    R.drawable.zrstos1,
                    getString(R.string.statzr)
                ),
                Stati(
                    null,
                    R.drawable.mestat13,
                    getString(R.string.statzr1)
                ),
                Stati(
                    null,
                    R.drawable.mestat14,
                    getString(R.string.statzr2)
                ),
                Stati(
                    null,
                    R.drawable.mestat15,
                    getString(R.string.statzr3)
                ),
                Stati(
                    null,
                    R.drawable.mestat16,
                    getString(R.string.statzr4)
                )
            )
            Thread { //создание нового потока
                for (i in 0..19) {
                    database.getDao().insertStat(statList[i])
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
            patternStat()
    }
}