package com.example.myapplication

import android.content.IntentSender.OnFinished
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityPlayBinding
import java.util.concurrent.TimeUnit

class playActivity : AppCompatActivity() {
             lateinit var binding: ActivityPlayBinding
             var quizlist= listOf<Quiz>(

                 Quiz("Victory day","17mar","7mar","16dcm","21feb","16dcm"),

                 Quiz("Valantaine day","26mar","14feb","7jun","","14feb"),

                 Quiz("Mother language day","26mar","21feb","16dcm","7mar","26mar"),

                 Quiz("International Worker, day","1may","10jun","26mar","21feb","1 may"),

                 Quiz("choklate day","13feb","21feb","26mar","16dcm","13feb")

             )

              var updatequestionNo=1
              var mlisecleft= 30000L


            var countDownTimer:CountDownTimer?=null

             override fun onCreate(savedInstanceState: Bundle?) {
              super.onCreate(savedInstanceState)
             binding= ActivityPlayBinding.inflate(layoutInflater)
             setContentView( binding.root)

             binding.countTv.text="$updatequestionNo/${quizlist.size}"
                 startCountDownTimer()

             }





  private  fun startCountDownTimer(){
                 countDownTimer=object:CountDownTimer( mlisecleft ,2000){

                     override fun onTick(millisunntilFinished: Long) {
                         mlisecleft=millisunntilFinished

                    val second=TimeUnit.MILLISECONDS.toSeconds(millisunntilFinished).toInt()

                       binding.countTv.text="Time Left $second"
                     }

                     override fun onFinish() {

                     }


                 }.start()


             }





}