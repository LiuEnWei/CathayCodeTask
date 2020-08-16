package com.wayne.cathaycodetask.ui.splash

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wayne.cathaycodetask.R
import com.wayne.cathaycodetask.ui.MainViewModel
import com.wayne.cathaycodetask.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment: BaseFragment(R.layout.fragment_splash) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val viewModel by viewModels<SplashViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.setToolbarShow(false)

        imgTaipeiZoo.setOnClickListener {
            startTaipeiZooAnim()
        }
        startTaipeiZooAnim()
    }

    private fun startTaipeiZooAnim() {
        lifecycleScope.launch {
            (imgTaipeiZoo.drawable as AnimatedVectorDrawable).start()
            delay(3000)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }
    }
}