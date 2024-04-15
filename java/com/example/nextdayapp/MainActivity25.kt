package com.example.nextdayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*

class MainActivity25 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var expenseAdapter: ExpenseAdapter
    private lateinit var expenseList: MutableList<ModelE>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main25)

        // Initialize Firebase Realtime Database
        dbRef = FirebaseDatabase.getInstance().reference.child("Expense")

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        expenseList = mutableListOf()
        expenseAdapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = expenseAdapter


        // Fetch feedback data from Firebase
        fetchExpenseData()
    }

    private fun fetchExpenseData() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                expenseList.clear()
                for (expenseSnapshot in dataSnapshot.children) {
                    val expenseTitle =
                        expenseSnapshot.child("expenseTitle").getValue(String::class.java)
                    val expenseTotal =
                        expenseSnapshot.child("expenseTotal").getValue(String::class.java)
                    val expenseDesc =
                        expenseSnapshot.child("expenseDesc").getValue(String::class.java)
                    val expenseModel = ModelE(expenseTitle, expenseTotal, expenseDesc)

                    expenseList.add(expenseModel)
                }
                expenseAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}