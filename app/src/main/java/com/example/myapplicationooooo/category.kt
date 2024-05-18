package com.example.myapplicationooooo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationooooo.databinding.FragmentCategoryBinding

class category : Fragment() {
    private lateinit var binding : FragmentCategoryBinding

    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.butStat.setOnClickListener {
            MAIN.navController.navigate(R.id.action_category_to_stat)
        }
        binding.butProfile.setOnClickListener {
            MAIN.navController.navigate(R.id.action_category_to_profile)
        }

        binding.butMedit.setOnClickListener{
            MAIN.navController.navigate(R.id.action_category_to_razdel_medit)
        }
        binding.butUoga.setOnClickListener{
            MAIN.navController.navigate(R.id.action_category_to_uoga)
        }
        binding.butDax.setOnClickListener{
            MAIN.navController.navigate(R.id.action_category_to_razdel_breath)
        }
        binding.butZar.setOnClickListener{
            MAIN.navController.navigate(R.id.action_category_to_razdel_zaradka)
        }


        binding.butMeditStat.setOnClickListener{
            bundle.putInt("patternStatId", 1)
            findNavController().navigate(R.id.action_category_to_patternStat, bundle)
        }

        binding.butUogaStat.setOnClickListener{
            bundle.putInt("patternStatId", 6)
            findNavController().navigate(R.id.action_category_to_patternStat, bundle)
        }

        binding.butDuStat.setOnClickListener{
            bundle.putInt("patternStatId", 11)
            findNavController().navigate(R.id.action_category_to_patternStat, bundle)
        }
        binding.butStatZar.setOnClickListener{
            bundle.putInt("patternStatId", 16)
            findNavController().navigate(R.id.action_category_to_patternStat, bundle)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            category()
    }
}