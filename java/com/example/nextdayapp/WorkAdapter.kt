package com.example.nextdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkAdapter(private val workList: List<ModelW>) :
    RecyclerView.Adapter<WorkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_work, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val work = workList[position]
        holder.textViewTitle.text = work.workTitle
        holder.textViewDesc.text = work.workDesc
        holder.textViewDate.text = work.workDate
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDesc)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }
}