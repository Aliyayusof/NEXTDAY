package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {

    //initial all component
    private lateinit var finance: Button
    private lateinit var health: Button
    private lateinit var work: Button
    private lateinit var toDo: Button
    private lateinit var info: Button
    private lateinit var manual: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //declare all component
        finance = findViewById(R.id.btnFinance)
        health = findViewById(R.id.btnHealth)
        work = findViewById(R.id.btnWork)
        toDo = findViewById(R.id.btnToDo)
        info = findViewById(R.id.btnInfo)
        manual = findViewById(R.id.btnManual)

        //function for the button
        finance.setOnClickListener {
            val i = Intent(this, MainActivity5::class.java)
            startActivity(i)
        }

        health.setOnClickListener {
            val i = Intent(this, MainActivity6::class.java)
            startActivity(i)
        }

        work.setOnClickListener {
            val i = Intent(this, MainActivity7::class.java)
            startActivity(i)
        }

        toDo.setOnClickListener {
            val i = Intent(this, MainActivity8::class.java)
            startActivity(i)
        }

        info.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }

        manual.setOnClickListener {
            val i = Intent(this, MainActivity27::class.java)
            startActivity(i)
        }
    }
}