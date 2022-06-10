package com.example.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnav.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomnav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(FragmentHome())
        bottomnav = findViewById(R.id.bottom_navigation)
        bottomnav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.Home -> loadFragment(FragmentHome())
                R.id.Perfil -> loadFragment(FragmentPerfil())
                R.id.Notificaciones -> loadFragment(FragmentNotificaciones())
                R.id.Calendario -> loadFragment(FragmentCalendario())
                R.id.Configuracion -> loadFragment(FragmentConfig())
            }
            true
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentcontainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}