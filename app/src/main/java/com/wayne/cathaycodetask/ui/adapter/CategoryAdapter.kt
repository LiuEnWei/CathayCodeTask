package com.wayne.cathaycodetask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.model.api.vo.Category
import com.wayne.cathaycodetask.ui.adapter.viewholder.CategoryViewHolder

class CategoryAdapter(var list: List<Category>, val onCategoryClickListener: OnCategoryClickListener) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position], onCategoryClickListener)
    }
}