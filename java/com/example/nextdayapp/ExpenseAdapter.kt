package com.example.nextdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private val expenseList: List<ModelE>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenseList[position]
        holder.textViewTitle.text = expense.expenseTitle
        holder.textViewTotal.text = expense.expenseTotal
        holder.textViewDesc.text = expense.expenseDesc
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewTotal: TextView = itemView.findViewById(R.id.textViewTotal)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDesc)
    }
}