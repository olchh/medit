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
            bundle.putInt("patternStatId", 2)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatMe2.setOnClickListener{
            bundle.putInt("patternStatId", 3)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatMe3.setOnClickListener{
            bundle.putInt("patternStatId", 4)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatMe4.setOnClickListener{
            bundle.putInt("patternStatId", 5)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo1.setOnClickListener{
            bundle.putInt("patternStatId", 7)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo2.setOnClickListener{
            bundle.putInt("patternStatId", 8)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo3.setOnClickListener{
            bundle.putInt("patternStatId", 9)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatUo4.setOnClickListener{
            bundle.putInt("patternStatId", 10)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu1.setOnClickListener{
            bundle.putInt("patternStatId", 12)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu2.setOnClickListener{
            bundle.putInt("patternStatId", 13)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu3.setOnClickListener{
            bundle.putInt("patternStatId", 14)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatDu4.setOnClickListener{
            bundle.putInt("patternStatId", 15)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr1.setOnClickListener{
            bundle.putInt("patternStatId", 17)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr2.setOnClickListener{
            bundle.putInt("patternStatId", 18)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr3.setOnClickListener{
            bundle.putInt("patternStatId", 19)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }

        binding.butStatZr4.setOnClickListener{
            bundle.putInt("patternStatId", 20)
            findNavController().navigate(R.id.action_stat_to_patternStat, bundle)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            stat()
    }
}