package com.example.rodoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rodoapp.R
import com.example.rodoapp.model.VehicleType
import kotlinx.android.synthetic.main.vehicle_type_item.view.*

class GridViewAdapter(val items: List<VehicleType>) : RecyclerView.Adapter<GridViewAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.vehicle_type_item, parent, false)
        return GridViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val item = items[position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int = items.size

    class GridViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: VehicleType) {
            itemView.carTypeIcon.setImageResource(item.drawable)
            itemView.carTypeLabel.text = item.name
        }
    }
}