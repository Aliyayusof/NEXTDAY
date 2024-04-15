package com.example.nextdayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity2 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef: DatabaseReference
    //initial all component
    private lateinit var submit: Button
    private lateinit var reset: Button
    private lateinit var name: EditText
    private lateinit var password: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //declare all component
        submit = findViewById(R.id.btnSubmit)
        reset = findViewById(R.id.btnReset)
        name = findViewById(R.id.eTName)
        password = findViewById(R.id.eTPassword)
        phone = findViewById(R.id.eTPhone)
        email = findViewById(R.id.eTEmail)

        //popup message when click button add record
        Toast.makeText(this, "Submit", Toast.LENGTH_LONG).show()

        submit.setOnClickListener {
            //call function saveEmployeeData
            //parameter - change the input data to string
            saveData(email.text.toString(),name.text.toString(),password.text.toString(),phone.text.toString())
        }

        reset.setOnClickListener {
            name.setText("")
            password.setText("")
            phone.setText("")
            email.setText("")
        }
    }

    //create the function saveData
    //this function send data to firebase
    //n = name
    //p = password
    //e = email
    //t = phone
    private fun saveData(e:String, n:String, p:String, t:String)
    {
        //getInstance = get object
        //customer refer to table
        //customer can change to other name
        //link database named customer
        dbRef = FirebaseDatabase.getInstance().getReference("Customer")

        //produce auto generate customer id
        //!! refer must had record or id cannot null
        val customerId = dbRef.push().key!!

        //customer is a object
        //push the data to database
        //customerId will autogenerate
        //data will output by user
        //input name, password, phone, email
        val em = Model(e, customerId, n, p, t)

        //setting to push data inside table
        dbRef.child(customerId).setValue(em)

            //success record, it will popup success
            .addOnCompleteListener{
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        //declare variable i to component to next pages/activity
        val i = Intent(this, MainActivity3::class.java)
        startActivity(i)
    }
}
