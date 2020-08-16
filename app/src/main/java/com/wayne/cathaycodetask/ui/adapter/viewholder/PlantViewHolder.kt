package com.wayne.cathaycodetask.ui.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.model.api.vo.Plant
import com.wayne.cathaycodetask.ui.adapter.OnPlantClickListener

class PlantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val imgPic = itemView.findViewById<ShapeableImageView>(R.id.imgPic)
    private val textName = itemView.findViewById<TextView>(R.id.textName)
    private val textAlsoKnow = itemView.findViewById<TextView>(R.id.textAlsoKnow)

    fun bind(plant: Plant, onPlantClickListener: OnPlantClickListener) {
        val context = itemView.context
        Glide.with(context).load(plant.picUrl).placeholder(R.drawable.bg_gray300).into(imgPic)
        textName.text = plant.nameCh
        textAlsoKnow.text = plant.alsoKnow

        itemView.setOnClickListener {
            imgPic.transitionName = plant.picUrl
            val extras = FragmentNavigatorExtras(
                imgPic to imgPic.transitionName
            )
            onPlantClickListener.onClick(plant, extras)
        }
    }

}