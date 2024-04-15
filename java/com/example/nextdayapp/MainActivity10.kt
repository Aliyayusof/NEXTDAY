package com.example.nextdayapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity10 : AppCompatActivity() {

    private val expensesList = mutableListOf<String>()
    private lateinit var recyclerViewExpenses : RecyclerView
    private lateinit var expensesAdapter: ExpensesAdapter
    private lateinit var btnAddEx : Button

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        btnAddEx = findViewById(R.id.buttonAddExpense)

        expensesAdapter = ExpensesAdapter(expensesList)
        recyclerViewExpenses.layoutManager = LinearLayoutManager(this)
        recyclerViewExpenses.adapter = expensesAdapter

        btnAddEx.setOnClickListener {
            // Logic to add a new expense
            // For simplicity, let's just add a sample expense
            val newExpense = "Expense ${expensesList.size + 1}"
            expensesList.add(newExpense)
            expensesAdapter.notifyDataSetChanged()
        }
    }
}