package com.wayne.cathaycodetask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.model.api.vo.Plant
import com.wayne.cathaycodetask.ui.adapter.viewholder.PlantViewHolder

class PlantAdapter(var list: List<Plant>, val onPlantClickListener: OnPlantClickListener) : RecyclerView.Adapter<PlantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(list[position], onPlantClickListener)
    }
}