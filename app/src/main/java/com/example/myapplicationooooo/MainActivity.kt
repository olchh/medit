package com.example.myapplicationooooo

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.myapplicationooooo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    var pref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

        pref = getSharedPreferences("us_data", Context.MODE_PRIVATE)//файлы могут исп только внутри приложения

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)


        changeStatusBarColor("#e7c697")





    }
    fun saveData(data: String){
        val editor = pref?.edit()//чтобы изм данные таблицы
        editor?.putString("user",data)//создание строки которую получим по ключу user
        editor?.apply()//сохранение в таблицу
    }

    //отвечает за выход из приложения (очистка внутренней памяти в данном случае)
    override fun onDestroy() {
        super.onDestroy()
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply()
    }

    //панель сверху тем же цветом, что и cardView
    private fun changeStatusBarColor(color:String){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window : Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
}