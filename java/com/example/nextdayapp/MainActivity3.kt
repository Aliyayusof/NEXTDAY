package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity3 : AppCompatActivity() {

    //initialize the component
    private lateinit var btnLog : Button
    private lateinit var email : EditText
    private lateinit var password : EditText

    //declare the firebase
    private lateinit var firebaseDatabase : FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //declare the component
        btnLog = findViewById(R.id.btnLogin)
        email = findViewById(R.id.emailLogin)
        password = findViewById(R.id.passwordLogin)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Customer")

        //function button login to activity
        btnLog.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty())
            {
                login(email, password)
            } else {
                Toast.makeText(this@MainActivity3, "All fields are mandatory", Toast.LENGTH_LONG).show()
            }
        }

    }
    //create the function login
    //function read data to firebase
    //p = password
    // e = email
    private fun login(email:String, password:String)
    {
        databaseReference.orderByChild("customerEmail").equalTo(email).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    for (custSnapshot in dataSnapshot.children){
                        val model = custSnapshot.getValue(Model::class.java)

                        if (model != null && model.customerPassword==password){
                            Toast.makeText(this@MainActivity3, "Login Successful", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@MainActivity3, MainActivity4::class.java))
                            finish()
                            return
                        }
                    }
                }

                Toast.makeText(this@MainActivity3, "Login Failed", Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(databaseError: DatabaseError){
                Toast.makeText(this@MainActivity3, "Database Error: ${databaseError.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}