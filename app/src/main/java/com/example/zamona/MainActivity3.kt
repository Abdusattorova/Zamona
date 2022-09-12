package com.example.zamona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.zamona.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.home->{
                    supportFragmentManager.beginTransaction().apply {
                       replace(R.id.flFragment,HomeFragment())
                           .commit()
                    }
                }
                R.id.settings->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,SettingsFragment())
                            .commit()
                    }
                }
                R.id.pusk->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,PuskFragment())
                            .commit()
                    }
                }
                R.id.chatFragment->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,ChatFragment())
                            .commit()
                    }
                }
                R.id.person->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,PersonFragment())
                            .commit()
                    }
                }
            }
            true
        }
    }
}