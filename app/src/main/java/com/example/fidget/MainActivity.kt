package com.example.fidget

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.View
import com.example.fidget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null


    private var restTimer : CountDownTimer?=null
    private var restProgress=0
    private var restTimerDuration : Long=10


    var count : Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnStart?.setOnClickListener {

            binding?.btnStart?.visibility=View.INVISIBLE
            binding?.btnPlay?.visibility=View.VISIBLE

            binding?.tvResult?.visibility=View.VISIBLE


            count++;
            binding?.tvResult?.text=count.toString()
            setTimer()
        }

        binding?.btnPlay?.setOnClickListener {
            count++;
            binding?.tvResult?.text=count.toString()
        }
    }

    private fun setTimer(){
        binding?.progressBar?.progress=restProgress


        restTimer = object : CountDownTimer(restTimerDuration*1000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text=(10-restProgress).toString()
            }

            override fun onFinish() {

                // when the rest view is finished, call the method to set up exercise view
                finish()
                val intent=Intent(this@MainActivity, FinishActivity::class.java)
                intent.putExtra("Result", count)
                startActivity(intent)
            }
        }.start()
    }
}