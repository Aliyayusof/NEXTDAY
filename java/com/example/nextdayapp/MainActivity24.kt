package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity24 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef: DatabaseReference
    //initial all component
    private lateinit var submitF: Button
    private lateinit var titleF: EditText
    private lateinit var totalF: EditText
    private lateinit var descF: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main24)

        submitF = findViewById(R.id.btnSubmitF)
        titleF = findViewById(R.id.eTTitleF)
        totalF = findViewById(R.id.eTTotalF)
        descF = findViewById(R.id.eTDescF)

        submitF.setOnClickListener {
            //call function saveEmployeeData
            //parameter - change the input data to string
            saveData(titleF.text.toString(), totalF.text.toString(), descF.text.toString())
        }

        //popup message when click button add record
        Toast.makeText(this, "Submit", Toast.LENGTH_LONG).show()
    }
    //create the function saveData
    //this function send data to firebase
    //n = name
    //p = password
    //e = email
    //t = phone
    private fun saveData(t:String, o:String, d:String)
    {
        //getInstance = get object
        //customer refer to table
        //customer can change to other name
        //link database named customer
        dbRef = FirebaseDatabase.getInstance().getReference("Expense")

        //produce auto generate customer id
        //!! refer must had record or id cannot null
        val expenseId = dbRef.push().key!!

        //customer is a object
        //push the data to database
        //customerId will autogenerate
        //data will output by user
        //input name, password, phone, email
        val em = ModelE(t, expenseId, o, d)

        //setting to push data inside table
        dbRef.child(expenseId).setValue(em)

            //success record, it will popup success
            .addOnCompleteListener{
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        //declare variable i to component to next pages/activity
        val i = Intent(this, MainActivity5::class.java)
        startActivity(i)
    }
}