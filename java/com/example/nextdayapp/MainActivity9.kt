package com.example.nextdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView

class MainActivity9 : AppCompatActivity() {

    private val header : MutableList<String> = ArrayList()
    private val body : MutableList<MutableList<String>> = ArrayList()
    private lateinit var exListView: ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        exListView = findViewById(R.id.exListView)

        val season1: MutableList<String> = ArrayList()
        season1.add("An electronic planner that you use on your smartphone or tablet.")

        val season2: MutableList<String> = ArrayList()
        season2.add("Most of smartphones or tablet are going to work fine")

        val season3: MutableList<String> = ArrayList()
        season3.add("No, it does not.")

        val season4: MutableList<String> = ArrayList()
        season4.add("It should be send notifications or reminders.")

        val season5: MutableList<String> = ArrayList()
        season5.add("Yes, you need to have internet access in order use this app")

        header.add("What is a digital planner?")
        header.add("What type of devices is compatible with?")
        header.add("Does the use of a pencil necessary? ")
        header.add("Does this digital planner send notifications?")
        header.add("Do I need to be on Wifi to use this planner?")

        body.add(season1)
        body.add(season2)
        body.add(season3)
        body.add(season4)
        body.add(season5)

        exListView.setAdapter(ExpandableListViewAdapter(this, header, body))



    }
}