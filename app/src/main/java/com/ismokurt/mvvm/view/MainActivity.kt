package com.ismokurt.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ismokurt.mvvm.R
import com.ismokurt.mvvm.databinding.ActivityMainBinding
import com.ismokurt.mvvm.view.fragments.MusicFragment
import com.ismokurt.mvvm.view.fragments.SettingsFragment
import com.ismokurt.mvvm.view.fragments.SingerFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(MusicFragment())


        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.musicPage -> replaceFragment(MusicFragment())
                R.id.singerPage -> replaceFragment(SingerFragment())
                R.id.settingPage -> replaceFragment(SettingsFragment())
                else -> {
                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}