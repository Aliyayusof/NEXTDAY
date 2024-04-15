package com.example.nextdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity18 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var healthAdapter: HealthAdapter
    private lateinit var healthList: MutableList<ModelH>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main18)

        // Initialize Firebase Realtime Database
        dbRef = FirebaseDatabase.getInstance().reference.child("Health")

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        healthList = mutableListOf()
        healthAdapter = HealthAdapter(healthList)
        recyclerView.adapter = healthAdapter


        // Fetch feedback data from Firebase
        fetchHealthData()
    }

    private fun fetchHealthData() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                healthList.clear()
                for (healthSnapshot in dataSnapshot.children) {
                    val healthTitle =
                        healthSnapshot.child("healthTitle").getValue(String::class.java)
                    val healthDesc =
                        healthSnapshot.child("healthDesc").getValue(String::class.java)
                    val healthDate =
                        healthSnapshot.child("healthDate").getValue(String::class.java)
                    val healthModel = ModelH(healthTitle, healthDesc, healthDate)

                    healthList.add(healthModel)
                }
                healthAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}
