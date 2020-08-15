package com.wayne.cathaycodetask.ui.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.model.api.vo.Category
import com.wayne.cathaycodetask.ui.adapter.OnCategoryClickListener

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val imgPic = itemView.findViewById<ShapeableImageView>(R.id.imgPic)
    private val textName = itemView.findViewById<TextView>(R.id.textName)
    private val textInfo = itemView.findViewById<TextView>(R.id.textInfo)
    private val textMemo = itemView.findViewById<TextView>(R.id.textMemo)

    fun bind(category: Category, onCategoryClickListener: OnCategoryClickListener) {
        val context = itemView.context
        Glide.with(context).load(category.picUrl).placeholder(R.drawable.bg_gray300).into(imgPic)
        textName.text = category.name
        textInfo.text = category.info
        textMemo.text = when {
            category.memo.isNullOrEmpty() -> context.getString(R.string.no_memo)
            else -> category.memo
        }

        itemView.setOnClickListener {
            imgPic.transitionName = category.picUrl
            val extras = FragmentNavigatorExtras(
                imgPic to imgPic.transitionName
            )
            onCategoryClickListener.onClick(category, extras)
        }
    }

}