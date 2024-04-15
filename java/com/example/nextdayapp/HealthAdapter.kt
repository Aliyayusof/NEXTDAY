package com.example.nextdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HealthAdapter(private val healthList: List<ModelH>) :
    RecyclerView.Adapter<HealthAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_health, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val health = healthList[position]
        holder.textViewTitle.text = health.healthTitle
        holder.textViewDesc.text = health.healthDesc
        holder.textViewDate.text = health.healthDate
    }

    override fun getItemCount(): Int {
        return healthList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDesc)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }
}