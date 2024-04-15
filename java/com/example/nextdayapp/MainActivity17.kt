package com.example.nextdayapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class MainActivity17 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef: DatabaseReference
    //initial all component
    private lateinit var submitT: Button
    private lateinit var titleT: EditText
    private lateinit var dateT: EditText
    private lateinit var descT: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        submitT = findViewById(R.id.btnSubmitT)
        titleT = findViewById(R.id.eTTitleT)
        descT = findViewById(R.id.eTDescT)
        dateT = findViewById(R.id.eTDateT)

        dateT.setOnClickListener{
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                {
                        view, year, monthOfYear, dayOfMonth ->

                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dateT.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        submitT.setOnClickListener {
            //call function saveEmployeeData
            //parameter - change the input data to string
            saveData(titleT.text.toString(), descT.text.toString(), dateT.text.toString())
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
    private fun saveData(t:String, d:String, a:String)
    {
        //getInstance = get object
        //customer refer to table
        //customer can change to other name
        //link database named customer
        dbRef = FirebaseDatabase.getInstance().getReference("ToDo")

        //produce auto generate customer id
        //!! refer must had record or id cannot null
        val toId = dbRef.push().key!!

        //customer is a object
        //push the data to database
        //customerId will autogenerate
        //data will output by user
        //input name, password, phone, email
        val em = ModelT(t, toId, d, a)

        //setting to push data inside table
        dbRef.child(toId).setValue(em)

            //success record, it will popup success
            .addOnCompleteListener{
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        //declare variable i to component to next pages/activity
        val i = Intent(this, MainActivity8::class.java)
        startActivity(i)
    }
}