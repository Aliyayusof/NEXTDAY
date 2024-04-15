package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity21 : AppCompatActivity() {

    //initial all component
    private lateinit var inF: Button
    private lateinit var exF: Button
    private lateinit var btnI: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main21)

        //declare all component
        inF = findViewById(R.id.btnInc)
        exF = findViewById(R.id.btnExp)
        btnI = findViewById(R.id.btnInfoF)

        //function for the button
        inF.setOnClickListener {
            val i = Intent(this, MainActivity22::class.java)
            startActivity(i)
        }

        exF.setOnClickListener {
            val i = Intent(this, MainActivity24::class.java)
            startActivity(i)
        }
        btnI.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }
    }
}