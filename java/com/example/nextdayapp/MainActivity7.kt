package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity7 : AppCompatActivity() {

    //initial all component
    private lateinit var startW: Button
    private lateinit var historyW: Button
    private lateinit var homeW: Button
    private lateinit var infoW: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        //declare all component
        startW = findViewById(R.id.btnStartW)
        historyW = findViewById(R.id.btnHistoryW)
        homeW = findViewById(R.id.btnHomeW)
        infoW = findViewById(R.id.btnInfoW)

        //function for the button
        startW.setOnClickListener {
            val i = Intent(this, MainActivity16::class.java)
            startActivity(i)
        }

        historyW.setOnClickListener {
            val i = Intent(this, MainActivity20::class.java)
            startActivity(i)
        }

        homeW.setOnClickListener {
            val i = Intent(this, MainActivity4::class.java)
            startActivity(i)
        }

        infoW.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }
    }
}