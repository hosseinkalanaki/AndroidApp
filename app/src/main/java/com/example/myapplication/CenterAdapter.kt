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

        val temp3TextView: TextView = itemView.findViewById(R.id.temp3TextView)
        val temp3ValueTextView: TextView = itemView.findViewById(R.id.temp3ValueTextView)


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

        holder.titleTextView.text = center.CenterName

        val sensor1=center.Sensors[0]
        holder.temp1TextView.text = sensor1.Name
        holder.temp1ValueTextView.text = sensor1.Value.toString()

        val sensor2=center.Sensors[1]
        holder.temp2TextView.text = sensor2.Name
        holder.temp2ValueTextView.text = sensor2.Value.toString()

        val sensor3=center.Sensors[2]
        holder.temp3TextView.text = sensor3.Name
        holder.temp3ValueTextView.text = sensor3.Value.toString()

        val sensor4=center.Sensors[3]
        holder.humidityTextView.text = sensor4.Name
        holder.humidityValueTextView.text = sensor4.Value.toString()

    }

    override fun getItemCount(): Int = centers.size
}
