package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity28 : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main28)

        fab = findViewById(R.id.floatingActionButton)

        fab.setOnClickListener {
            val i = Intent(this, MainActivity29::class.java)
            startActivity(i)
        }
    }
}