package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity15 : AppCompatActivity() {

    //initial all component
    private lateinit var apptH: Button
    private lateinit var bmiH: Button
    private lateinit var btnI: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main15)

        //declare all component
        apptH = findViewById(R.id.btnApptH)
        bmiH = findViewById(R.id.btnBmiH)
        btnI = findViewById(R.id.btnInfoH)

        //function for the button
        apptH.setOnClickListener {
            val i = Intent(this, MainActivity14::class.java)
            startActivity(i)
        }

        bmiH.setOnClickListener {
            val i = Intent(this, MainActivity12::class.java)
            startActivity(i)
        }
        btnI.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }
    }
}