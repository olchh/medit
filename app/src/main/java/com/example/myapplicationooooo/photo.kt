    package com.example.myapplicationooooo

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.lifecycle.asLiveData
    import com.example.myapplicationooooo.databinding.FragmentPhotoBinding
    import com.example.myapplicationooooo.entity.MainDB

    class photo : Fragment() {
        private lateinit var binding : FragmentPhotoBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentPhotoBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.icon1.setOnClickListener {
                DataBasePhoto("iconprof1")
                MAIN.navController.navigate(R.id.action_photo2_to_profile)
            }
            binding.icon2.setOnClickListener {
                DataBasePhoto("iconprof2")
                MAIN.navController.navigate(R.id.action_photo2_to_profile)
            }
            binding.icon3.setOnClickListener {

                DataBasePhoto("iconprof3")
                MAIN.navController.navigate(R.id.action_photo2_to_profile)
            }
            binding.icon4.setOnClickListener {
                DataBasePhoto("iconprof4")
                MAIN.navController.navigate(R.id.action_photo2_to_profile)
            }
}
        fun DataBasePhoto(image: String) {
            val database = MainDB.getDB(MAIN)

            var id = arguments?.getInt("photoid")

            Thread{database.getDao().updateUserImage(image, id!!)}.start()

            database.getDao().getUser(id!!).asLiveData().observe(MAIN) {list->

                var uuserr = ""
                list?.forEach { user ->
                    uuserr =
                        """
                {
                    "user":{
                        "name" : "${user.name}",
                        "login" : "${user.login}",
                        "id" : "${user.id_user}",
                        "image" : "${image}"
                    }
                }
                """
                    MAIN.deleteData()
                    MAIN.saveData(uuserr)

                }
            }
        }

        companion object {
        @JvmStatic
        fun newInstance() =
        photo()
        }
    }
