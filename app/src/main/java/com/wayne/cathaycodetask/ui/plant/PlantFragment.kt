package com.wayne.cathaycodetask.ui.plant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.ui.base.BaseFragment

class PlantFragment: BaseFragment(R.layout.fragment_plant) {
    private val viewModel by viewModels<PlantViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}