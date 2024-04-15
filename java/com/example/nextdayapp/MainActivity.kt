package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var start: Button
    private lateinit var log: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declare all component
        start = findViewById(R.id.btnStart)
        log = findViewById(R.id.btnLogIn)

        //function for the button
        start.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
        log.setOnClickListener {
            val i = Intent(this, MainActivity3::class.java)
            startActivity(i)
        }
    }
}
