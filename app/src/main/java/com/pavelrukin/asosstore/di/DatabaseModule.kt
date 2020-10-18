package com.pavelrukin.asosstore.di

import android.app.Application
import androidx.room.Room
import com.pavelrukin.asosstore.db.ProductDao
import com.pavelrukin.asosstore.db.ProductDatabase
import com.pavelrukin.asosstore.utils.Constants
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): ProductDatabase {
        return Room.databaseBuilder(application, ProductDatabase::class.java, Constants.DATABSE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCountriesDao(database: ProductDatabase): ProductDao {
        return  database.getProductDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }
}