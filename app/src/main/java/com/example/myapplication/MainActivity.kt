package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Button

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*


        class MainActivity() : AppCompatActivity() {
                lateinit var binding: ActivityMainBinding
            override fun onCreate(savedInstanceState:Bundle?) {
                super.onCreate(savedInstanceState)


                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)


                binding.playbtn.setOnClickListener{
                  var intent=Intent(this,playActivity::class.java)
                    startActivity(intent)

              }

            }




            }






