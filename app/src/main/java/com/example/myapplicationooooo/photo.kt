    package com.example.myapplicationooooo

    import android.media.Image
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.asLiveData
    import androidx.lifecycle.lifecycleScope
    import androidx.lifecycle.liveData
    import com.example.myapplicationooooo.databinding.FragmentPhotoBinding
    import com.example.myapplicationooooo.entity.MainDB
    import kotlinx.coroutines.*
    import kotlinx.coroutines.flow.collect


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


            val database = MainDB.getDB(MAIN)

            var id = arguments?.getInt("photoid")

            fun DataBasePhoto(image: String): LiveData<String> = liveData {
                val list = database.getDao().getUser(id!!).asLiveData().value
                val uuserr = list?.joinToString("") { user ->
                    """
                {
                    "user":{
                        "name" : "${user.name}",
                        "login" : "${user.login}",
                        "id" : "${user.id}",
                        "image" : "${image}"
                    }
                }
                """.trimIndent()
                }
                emit(uuserr ?: "")
            }

            binding.icon2.setOnClickListener {
                lifecycleScope.launch(Dispatchers.IO) {
                    database.getDao().updateUserImage("R.id.iconprof2", id!!)
                    MAIN.deleteData()
                    val data = DataBasePhoto("R.id.iconprof2").value
                    withContext(Dispatchers.Main) {
                        data?.let {
                            MAIN.saveData(it)
                        }

                        MAIN.navController.navigate(R.id.action_photo2_to_profile)
                    }
                }
            }




}

companion object {
@JvmStatic
fun newInstance() =
photo()
        }
    }



