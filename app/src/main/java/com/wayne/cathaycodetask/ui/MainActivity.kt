package com.wayne.cathaycodetask.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wayne.cathaycodetask.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var appBarConfig: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appBarConfig = AppBarConfiguration(setOf(R.id.splashFragment, R.id.homeFragment))
        toolbar.setupWithNavController(findNavController(), appBarConfig)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(findNavController(), appBarConfig)

        viewModel.title.observe(this, Observer {
            it?.let {
                toolbar.title = it
            }
        })

        viewModel.isToolbarShow.observe(this, Observer {
            when (it) {
                true -> toolbar.visibility = View.VISIBLE
                else -> toolbar.visibility = View.GONE
            }
        })
    }

    private fun findNavController(): NavController {
        return Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController().navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}