package com.pavelrukin.asosstore.db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pavelrukin.asosstore.model.detail_product.DetailResponse


@Database(entities = [DetailResponse::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
 abstract class ProductDatabase : RoomDatabase() {

     abstract fun getProductDao(): ProductDao

}
