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

class MainActivity19 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var toDoAdapter: ToDoAdapter
    private lateinit var toDoList: MutableList<ModelT>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main19)

        // Initialize Firebase Realtime Database
        dbRef = FirebaseDatabase.getInstance().reference.child("ToDo")

        // Initialize RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        toDoList = mutableListOf()
        toDoAdapter = ToDoAdapter(toDoList)
        recyclerView.adapter = toDoAdapter


        // Fetch feedback data from Firebase
        fetchToDoData()
    }

    private fun fetchToDoData() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                toDoList.clear()
                for (toDoSnapshot in dataSnapshot.children) {
                    val toTitle =
                        toDoSnapshot.child("toTitle").getValue(String::class.java)
                    val toDesc =
                        toDoSnapshot.child("toDesc").getValue(String::class.java)
                    val toDate =
                        toDoSnapshot.child("toDate").getValue(String::class.java)
                    val toDoModel = ModelT(toTitle, toDesc, toDate)

                    toDoList.add(toDoModel)
                }
                toDoAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}
