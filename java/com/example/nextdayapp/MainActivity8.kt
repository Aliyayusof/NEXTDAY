package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity8 : AppCompatActivity() {

    //initial all component
    private lateinit var startT: Button
    private lateinit var historyT: Button
    private lateinit var homeT: Button
    private lateinit var infoT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        //declare all component
        startT = findViewById(R.id.btnStartT)
        historyT = findViewById(R.id.btnHistoryT)
        homeT = findViewById(R.id.btnHomeT)
        infoT = findViewById(R.id.btnInfoT)

        //function for the button
        startT.setOnClickListener {
            val i = Intent(this, MainActivity17::class.java)
            startActivity(i)
        }

        historyT.setOnClickListener {
            val i = Intent(this, MainActivity19::class.java)
            startActivity(i)
        }

        homeT.setOnClickListener {
            val i = Intent(this, MainActivity4::class.java)
            startActivity(i)
        }

        infoT.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }
    }
}