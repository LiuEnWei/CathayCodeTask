package com.wayne.cathaycodetask.ui.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.model.Result
import com.wayne.cathaycodetask.model.api.vo.Plant
import com.wayne.cathaycodetask.ui.MainViewModel
import com.wayne.cathaycodetask.ui.adapter.OnPlantClickListener
import com.wayne.cathaycodetask.ui.adapter.PlantAdapter
import com.wayne.cathaycodetask.ui.base.BaseFragment
import com.wayne.cathaycodetask.utils.getRecyclerViewDivider
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment: BaseFragment(R.layout.fragment_category), OnPlantClickListener {
    private val viewModel by viewModels<CategoryViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()
    private var plantAdapter: PlantAdapter? = null

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
            textCategoryType.text = category.category
            category.name?.let { name ->
                mainViewModel.setTitle(name)
                viewModel.getPlant(name)
            }
        }
        mainViewModel.setToolbarShow(true)

        plantAdapter = PlantAdapter(arrayListOf(), this)
        listPlant.adapter = plantAdapter
        listPlant.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        listPlant.addItemDecoration(requireContext().getRecyclerViewDivider(R.drawable.divider_category))

        viewModel.plants.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    it.result?.let { list ->
                        plantAdapter?.list = list
                        plantAdapter?.notifyDataSetChanged()
                    }
                }

                is Result.Error -> {
                    showErrorMessage(it.throwable.message)
                }
            }
        })
    }

    override fun onClick(plant: Plant, extras: Navigator.Extras) {
        findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToPlantFragment(plant), extras)
    }
}