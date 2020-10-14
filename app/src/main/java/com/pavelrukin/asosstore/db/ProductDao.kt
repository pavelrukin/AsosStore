package com.pavelrukin.asosstore.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pavelrukin.asosstore.model.product.Product

/*@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE product.id = :id")
    suspend fun getProduct(id: Int): Product?
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsert(product: Product)

    @Query("SELECT *FROM product")
    fun getAllProducts(): LiveData<List<Product>>

    @Delete
    suspend fun deleteProduct(product: Product)
}*/
