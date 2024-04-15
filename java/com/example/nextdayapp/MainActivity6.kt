package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6 : AppCompatActivity() {

    //initial all component
    private lateinit var startH: Button
    private lateinit var homeH: Button
    private lateinit var historyH: Button
    private lateinit var infoH: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        //declare all component
        startH = findViewById(R.id.btnStartH)
        historyH = findViewById(R.id.btnHistoryH)
        homeH = findViewById(R.id.btnHomeH)
        infoH = findViewById(R.id.btnInfoH)

        //function for the button
        startH.setOnClickListener {
            val i = Intent(this, MainActivity15::class.java)
            startActivity(i)
        }

        historyH.setOnClickListener {
            val i = Intent(this, MainActivity18::class.java)
            startActivity(i)
        }

        homeH.setOnClickListener {
            val i = Intent(this, MainActivity4::class.java)
            startActivity(i)
        }

        infoH.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }
    }
}