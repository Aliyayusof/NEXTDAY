package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {

    //initial all component
    private lateinit var startF: Button
    private lateinit var homeF: Button
    private lateinit var historyF: Button
    private lateinit var infoF: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        //declare all component
        startF = findViewById(R.id.btnStartF)
        homeF = findViewById(R.id.btnHomeF)
        historyF = findViewById(R.id.btnHistoryF)
        infoF = findViewById(R.id.btnInfoF)

        //function for the button
        startF.setOnClickListener {
            val i = Intent(this, MainActivity21::class.java)
            startActivity(i)
        }

        historyF.setOnClickListener {
            val i = Intent(this, MainActivity26::class.java)
            startActivity(i)
        }

        homeF.setOnClickListener {
            val i = Intent(this, MainActivity4::class.java)
            startActivity(i)
        }

        infoF.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }
    }
}