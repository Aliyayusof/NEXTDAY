package com.example.nextdayapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val toDoList: List<ModelT>) :
    RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = toDoList[position]
        holder.textViewTitle.text = todo.toTitle
        holder.textViewDesc.text = todo.toDesc
        holder.textViewDate.text = todo.toDate
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDesc)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }
}