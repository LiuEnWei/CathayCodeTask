package com.wayne.cathaycodetask.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.model.Result
import com.wayne.cathaycodetask.model.api.vo.Category
import com.wayne.cathaycodetask.ui.MainViewModel
import com.wayne.cathaycodetask.ui.adapter.CategoryAdapter
import com.wayne.cathaycodetask.ui.adapter.OnCategoryClickListener
import com.wayne.cathaycodetask.ui.base.BaseFragment
import com.wayne.cathaycodetask.utils.getRecyclerViewDivider
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment: BaseFragment(R.layout.fragment_home), OnCategoryClickListener {
    private val viewModel by viewModels<HomeViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()
    private var categoryAdapter: CategoryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter = CategoryAdapter(arrayListOf(), this)
        listCategory.adapter = categoryAdapter
        listCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        listCategory.addItemDecoration(requireContext().getRecyclerViewDivider(R.drawable.divider_category))

        mainViewModel.setTitle(getString(R.string.home_title))
        mainViewModel.setToolbarShow(true)

        viewModel.categories.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    it.result?.let { list ->
                        categoryAdapter?.list = list
                        categoryAdapter?.notifyDataSetChanged()
                    }
                }

                is Result.Error -> {
                    showErrorMessage(it.throwable.message)
                }
            }
        })

        viewModel.getPlant()
    }

    override fun onClick(category: Category, extras: Navigator.Extras) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCategoryFragment(category), extras)
    }
}