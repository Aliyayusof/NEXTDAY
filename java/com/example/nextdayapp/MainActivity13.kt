package com.example.nextdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*

class MainActivity13 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var financeAdapter: FinanceAdapter
    private lateinit var financeList: MutableList<ModelF>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        // Initialize Firebase Realtime Database
        dbRef = FirebaseDatabase.getInstance().reference.child("Finance")

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        financeList = mutableListOf()
        financeAdapter = FinanceAdapter(financeList)
        recyclerView.adapter = financeAdapter


        // Fetch feedback data from Firebase
        fetchFinanceData()
    }

    private fun fetchFinanceData() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                financeList.clear()
                for (financeSnapshot in dataSnapshot.children) {
                    val financeTitle =
                        financeSnapshot.child("financeTitle").getValue(String::class.java)
                    val financeTotal =
                        financeSnapshot.child("financeTotal").getValue(String::class.java)
                    val financeDesc =
                        financeSnapshot.child("financeDesc").getValue(String::class.java)
                    val financeModel = ModelF(financeTitle, financeTotal, financeDesc)

                    financeList.add(financeModel)
                }
                financeAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}