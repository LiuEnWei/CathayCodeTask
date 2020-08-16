package com.wayne.cathaycodetask.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.ui.base.BaseFragment

class SplashFragment: BaseFragment(R.layout.fragment_splash) {
    private val viewModel by viewModels<SplashViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}