package com.example.myapplication

import Center
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CenterAdapter(private val centers: List<Center>) :

    RecyclerView.Adapter<CenterAdapter.CenterViewHolder>() {

    class CenterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

        val temp1TextView: TextView = itemView.findViewById(R.id.temp1TextView)
        val temp1ValueTextView: TextView = itemView.findViewById(R.id.temp1ValueTextView)

        val temp2TextView: TextView = itemView.findViewById(R.id.temp2TextView)
        val temp2ValueTextView: TextView = itemView.findViewById(R.id.temp2ValueTextView)

        val humidityTextView: TextView = itemView.findViewById(R.id.humidityTextView)
        val humidityValueTextView: TextView = itemView.findViewById(R.id.humidityValueTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CenterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CenterViewHolder, position: Int) {
        val center = centers[position]
        Log.d("RecyclerViewCheck", "Binding Center: ${center.centerNumber}")
        holder.titleTextView.text = "مرکز شماره ${center.centerNumber}"

        holder.temp1TextView.text = "دمای 1:"
        holder.temp1ValueTextView.text = "${center.temperature1}"

        holder.temp2TextView.text = "دمای 2:"
        holder.temp2ValueTextView.text = "${center.temperature2}"

        holder.humidityTextView.text = "رطوبت: "
        holder.humidityValueTextView.text = "${center.humidity}"

    }

    override fun getItemCount(): Int = centers.size
}
