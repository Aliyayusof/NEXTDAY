package com.example.nextdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*

class MainActivity23 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var incomeAdapter: IncomeAdapter
    private lateinit var incomeList: MutableList<ModelN>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main23)

        // Initialize Firebase Realtime Database
        dbRef = FirebaseDatabase.getInstance().reference.child("Income")

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        incomeList = mutableListOf()
        incomeAdapter = IncomeAdapter(incomeList)
        recyclerView.adapter = incomeAdapter


        // Fetch feedback data from Firebase
        fetchIncomeData()
    }

    private fun fetchIncomeData() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                incomeList.clear()
                for (incomeSnapshot in dataSnapshot.children) {
                    val incomeTitle =
                        incomeSnapshot.child("incomeTitle").getValue(String::class.java)
                    val incomeTotal =
                        incomeSnapshot.child("incomeTotal").getValue(String::class.java)
                    val incomeDesc =
                        incomeSnapshot.child("incomeDesc").getValue(String::class.java)
                    val incomeModel = ModelN(incomeTitle, incomeTotal, incomeDesc)

                    incomeList.add(incomeModel)
                }
                incomeAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}