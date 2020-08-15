package com.wayne.cathaycodetask.ui.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.ui.MainViewModel
import com.wayne.cathaycodetask.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment: BaseFragment(R.layout.fragment_category) {
    private val viewModel by viewModels<CategoryViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val category = CategoryFragmentArgs.fromBundle(it).category
            imgPic.transitionName = category.picUrl
            Glide.with(requireContext()).load(category.picUrl).placeholder(R.drawable.bg_gray300).into(imgPic)
            textInfo.text = category.info
            textMemo.text = when {
                category.memo.isNullOrEmpty() -> requireContext().getString(R.string.no_memo)
                else -> category.memo
            }

            mainViewModel.title.value = category.name
        }
    }
}