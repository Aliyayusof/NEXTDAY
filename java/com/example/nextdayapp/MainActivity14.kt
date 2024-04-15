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
import java.util.*

class MainActivity14 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef: DatabaseReference
    //initial all component
    private lateinit var submitH: Button
    private lateinit var titleH: EditText
    private lateinit var dateH: EditText
    private lateinit var descH: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)

        submitH = findViewById(R.id.btnSubmitH)
        titleH = findViewById(R.id.eTTitleH)
        descH = findViewById(R.id.eTDescH)
        dateH = findViewById(R.id.eTDateH)

        dateH.setOnClickListener{
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                {
                    view, year, monthOfYear, dayOfMonth ->

                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dateH.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        submitH.setOnClickListener {
            //call function saveEmployeeData
            //parameter - change the input data to string
            saveData(titleH.text.toString(), descH.text.toString(), dateH.text.toString())
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
        dbRef = FirebaseDatabase.getInstance().getReference("Health")

        //produce auto generate customer id
        //!! refer must had record or id cannot null
        val healthId = dbRef.push().key!!

        //customer is a object
        //push the data to database
        //customerId will autogenerate
        //data will output by user
        //input name, password, phone, email
        val em = ModelH(t, healthId, d, a)

        //setting to push data inside table
        dbRef.child(healthId).setValue(em)

            //success record, it will popup success
            .addOnCompleteListener{
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        //declare variable i to component to next pages/activity
        val i = Intent(this, MainActivity6::class.java)
        startActivity(i)
    }
}