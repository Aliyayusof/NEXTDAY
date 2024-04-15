package com.example.nextdayapp

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TodoItem : AppCompatActivity() {

    private lateinit var cB: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_todo)

        // Initialize RecyclerView and adapter
        cB = findViewById(R.id.checkBox)

        cB.isChecked = true

        cB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this, "Done", Toast.LENGTH_LONG).show()
            }
        }
    }
}