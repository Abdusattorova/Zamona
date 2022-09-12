package com.example.zamona

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.zamona.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            sharedPreferences =this.getSharedPreferences("shared", 0)!!
            editor = sharedPreferences.edit()
        var value=intent?.getIntExtra("keyy",1)
            if (sharedPreferences.getBoolean("key", false)&& value==1) {
                Handler(Looper.getMainLooper()).postDelayed({
                    finish()
                   var intent=Intent(this,MainActivity3::class.java)
                  startActivity(intent)
                }, 2000)
            } else
            {
                Handler(Looper.getMainLooper()).postDelayed({
                    finish()
                    var intent=Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                    editor.putBoolean("key", true)
                    editor.commit()
                }, 2000)

            }
    }
}