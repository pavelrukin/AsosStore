package com.pavelrukin.asosstore.di

import com.pavelrukin.asosstore.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        ProductRepository(get(),get())
    }
}
