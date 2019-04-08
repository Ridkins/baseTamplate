package com.rud.basetamplate.module

import com.rud.basetamplate.view.main.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext


val viewModelModule = applicationContext {
    viewModel { MainViewModel(get()) }
}