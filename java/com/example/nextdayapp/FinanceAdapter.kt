package com.example.nextdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FinanceAdapter(private val financeList: List<ModelF>) :
    RecyclerView.Adapter<FinanceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_finance, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val finance = financeList[position]
        holder.textViewTitle.text = finance.financeTitle
        holder.textViewTotal.text = finance.financeTotal
        holder.textViewDesc.text = finance.financeDesc
    }

    override fun getItemCount(): Int {
        return financeList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewTotal: TextView = itemView.findViewById(R.id.textViewTotal)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDesc)
    }
}