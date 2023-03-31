package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityPlayBinding
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
       lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityResultBinding.inflate (layoutInflater)
        setContentView(binding.root)

         var Skip=intent.getIntExtra("skip",0)

        var Correct=intent.getIntExtra("right",0)

        var wrong=intent.getIntExtra("wrong",0)

        var Namofqes=intent.getIntExtra("namofqes",0)

       binding.showreslet.text="Namqes:$Namofqes\n" +

               "skip:$Skip\n" +


               "correct:$Correct\n" +


               "wrong:$wrong"

    }


}