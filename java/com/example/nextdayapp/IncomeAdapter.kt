package com.example.nextdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IncomeAdapter(private val incomeList: List<ModelN>) :
    RecyclerView.Adapter<IncomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_income, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val income = incomeList[position]
        holder.textViewTitle.text = income.incomeTitle
        holder.textViewTotal.text = income.incomeTotal
        holder.textViewDesc.text = income.incomeDesc
    }

    override fun getItemCount(): Int {
        return incomeList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewTotal: TextView = itemView.findViewById(R.id.textViewTotal)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDesc)
    }
}