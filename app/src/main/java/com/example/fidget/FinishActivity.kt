package com.example.fidget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fidget.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {
    private var binding: ActivityFinishBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var string: String=binding?.tvResult2?.text.toString()
        var res=intent.getIntExtra("Result", 0)
        binding?.tvResult2?.text=string+" "+res.toString()
        binding?.tvResult2?.visibility=View.VISIBLE

        binding?.btnFinish?.setOnClickListener {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}