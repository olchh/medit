package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentStatBinding

class stat : Fragment() {

    private lateinit var binding : FragmentStatBinding

    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.butHomeSt.setOnClickListener {
            MAIN.navController.navigate(R.id.action_stat_to_category)
        }
        binding.butProfSt.setOnClickListener {
            MAIN.navController.navigate(R.id.action_stat_to_profile)
        }


        binding.butStatMe1.setOnClickListener{
            val text = getString(R.string.statme1)
            //подгружаем текст
            bundle.putString("patternStatText", text)
            val image = R.drawable.mestat1
            //подгружаем картинку
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatMe2.setOnClickListener{
            val text = getString(R.string.statme2)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat2
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatMe3.setOnClickListener{
            val text = getString(R.string.statme3)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat3
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatMe4.setOnClickListener{
            val text = getString(R.string.statme4)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat4
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo1.setOnClickListener{
            val text = getString(R.string.statuo1)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat5
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo2.setOnClickListener{
            val text = getString(R.string.statuo2)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat6
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo3.setOnClickListener{
            val text = getString(R.string.statuo3)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat7
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo4.setOnClickListener{
            val text = getString(R.string.statuo4)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat8
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu1.setOnClickListener{
            val text = getString(R.string.statdu1)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat9
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu2.setOnClickListener{
            val text = getString(R.string.statdu2)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat10
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu3.setOnClickListener{
            val text = getString(R.string.statdu3)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat11
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu4.setOnClickListener{
            val text = getString(R.string.statdu4)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat12
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr1.setOnClickListener{
            val text = getString(R.string.statzr1)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat13
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr2.setOnClickListener{
            val text = getString(R.string.statzr2)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat14
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr3.setOnClickListener{
            val text = getString(R.string.statzr3)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat15
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr4.setOnClickListener{
            val text = getString(R.string.statzr4)
            bundle.putString("patternStatText", text)

            val image = R.drawable.mestat16
            bundle.putInt("patternStatImage", image)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            stat()
    }
}