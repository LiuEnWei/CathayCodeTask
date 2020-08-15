package com.wayne.cathaycodetask.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.koin.core.KoinComponent

abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application), KoinComponent