package com.pavelrukin.asosstore.di

import com.pavelrukin.asosstore.AsosStoreApp
import com.pavelrukin.asosstore.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), app = androidApplication() as AsosStoreApp)
    }
}