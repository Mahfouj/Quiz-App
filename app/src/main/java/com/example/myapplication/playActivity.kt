package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityPlayBinding
import java.util.concurrent.TimeUnit


class playActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding
    var quizlist = listOf<Quiz>(

        Quiz("Victory day", "17mar", "7mar", "16dcm", "21feb", "16dcm"),

        Quiz("Valantaine day", "26mar", "14feb", "7jun", "16feb", "14feb"),

        Quiz("Mother language day", "26mar", "21feb", "16dcm", "7mar", "26mar"),

        Quiz("International Worker, day", "1may", "10jun", "26mar", "21feb", "1may"),

        Quiz("choklate day", "13feb", "21feb", "26mar", "16dcm", "13feb")

    )

    var updatequestionNo = 1

    var Milisleftsec = 30000L

    var  qIndex=0

    var hasFinished = false

    var Skip = 0

    var Correct = 0

    var wrong = 0

    var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initQuestion()

        binding.countTv.text = "$updatequestionNo/${quizlist.size}"
        startCountDownTimer()

        binding.buttonnext.setOnClickListener{
            showNextQuestion()
        }




    }

    private fun initQuestion() {
        val quiz = quizlist[qIndex]
        binding.apply {
            qustv.text = quiz.question
            qes1.text = quiz.option1
            qes2.text = quiz.option2
            qes3.text = quiz.option3
            qes4.text = quiz.option4
        }


    }


    private fun showNextQuestion() {
        checkAnwser()
        binding.apply {
            if (updatequestionNo < quizlist.size - 1) {
                updatequestionNo++
                countTv.text = "$updatequestionNo/${quizlist.size}"
            }

            if (qIndex <= quizlist.size - 1) {
                initQuestion()
            } else {
                hasFinished = true

            }

            binding.QuizGroup.clearCheck()
        }
    }

    private fun checkAnwser() {
        binding.apply {
            if (QuizGroup.checkedRadioButtonId == -1) {
                Skip++

            } else {

                val checkButton = findViewById<RadioButton>(QuizGroup.checkedRadioButtonId)

                val checkAnwser = checkButton.text.toString()

                if (checkAnwser == quizlist[qIndex].RightAnswer) {
                    Correct++
                    scoretv.text = "Score:$Correct"
                    countDownTimer?.cancel()
                    showAlertDailog("Right Anwser")

                } else {
                    wrong++
                   scoretv.text="Score:$wrong"
                    countDownTimer?.cancel()
                    showAlertDailog("Wrong Anwser")
                }
            }

            }
              if (qIndex<=quizlist.size-1) {
                  qIndex++
              }else{

                  showAlertDailog("Finshed")

              }


    }



        private fun startCountDownTimer() {
            countDownTimer = object : CountDownTimer(Milisleftsec, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    Milisleftsec = millisUntilFinished
                    val second = TimeUnit.MILLISECONDS.toSeconds(Milisleftsec).toInt()
                    binding.timetv.text = "Time Left $second"

                }

                override fun onFinish() {
                    showNextQuestion()

                }


            }.start()


        }



          private fun showAlertDailog(message:String){

              val builder =AlertDialog.Builder(this,)
              builder.setTitle(message)
 

         builder.setPositiveButton("ok",object :DialogInterface.OnClickListener{
             override fun onClick(dialog: DialogInterface?, Which: Int) {
                  if (message=="Finshed"){

                      countDownTimer?.cancel()


                       val intent = Intent(this@playActivity,ResultActivity::class.java)

                      intent.putExtra("skip",Skip)
                      intent.putExtra("right",Correct)
                      intent.putExtra("wrong",wrong)
                     intent.putExtra("namofqes",quizlist.size)

                      startActivity(intent)



                  }


                 countDownTimer?.start()
             }

         })

              val alertDialog=builder.create()
              alertDialog.show()


             }




}





private fun AlertDialog.Builder.setPositiveButton(
    s: String,
    onClickListener: DialogInterface.OnClickListener,
    function: () -> Unit
) {



}








































