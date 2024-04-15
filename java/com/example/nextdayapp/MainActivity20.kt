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

class MainActivity20 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var workAdapter: WorkAdapter
    private lateinit var workList: MutableList<ModelW>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main20)

        // Initialize Firebase Realtime Database
        dbRef = FirebaseDatabase.getInstance().reference.child("Work")

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        workList = mutableListOf()
        workAdapter = WorkAdapter(workList)
        recyclerView.adapter = workAdapter


        // Fetch feedback data from Firebase
        fetchWorkData()
    }

    private fun fetchWorkData() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                workList.clear()
                for (workSnapshot in dataSnapshot.children) {
                    val workTitle =
                        workSnapshot.child("workTitle").getValue(String::class.java)
                    val workDesc =
                        workSnapshot.child("workDesc").getValue(String::class.java)
                    val workDate =
                        workSnapshot.child("workDate").getValue(String::class.java)
                    val workModel = ModelW(workTitle, workDesc, workDate)

                    workList.add(workModel)
                }
                workAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}
