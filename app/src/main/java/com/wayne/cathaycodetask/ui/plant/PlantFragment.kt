package com.wayne.cathaycodetask.ui.plant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.ui.MainViewModel
import com.wayne.cathaycodetask.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_plant.*

class PlantFragment: BaseFragment(R.layout.fragment_plant) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val viewModel by viewModels<PlantViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val plant = PlantFragmentArgs.fromBundle(it).plant
            imgPic.transitionName = plant.picUrl
            Glide.with(requireContext()).load(plant.picUrl).placeholder(R.drawable.bg_gray300).into(imgPic)

            textName.text = plant.nameCh
            textNameLatin.text = plant.nameLatin

            textFamily.text = plant.family
            textGenus.text = plant.genus

            textAlsoKnow.text = getString(R.string.plant_also_know, plant.alsoKnow)
            textBrief.text = getString(R.string.plant_brief, plant.brief)
            textFeature.text = getString(R.string.plant_feature, plant.feature)
            textUse.text = getString(R.string.plant_use, plant.use)
            textUpdate.text = getString(R.string.plant_update, plant.update)

            plant.nameCh?.let { name ->
                mainViewModel.setTitle(name)
            }
        }

    }
}