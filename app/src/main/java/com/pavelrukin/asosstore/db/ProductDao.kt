package com.pavelrukin.asosstore.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pavelrukin.asosstore.model.detail_product.DetailResponse


@Dao
interface ProductDao {

    @Update(entity = DetailResponse::class)
    suspend fun updateCount (product: DetailResponse)

    @Query("SELECT * FROM product WHERE product.id = :id")
    suspend fun getProduct(id: Int): DetailResponse?
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: DetailResponse)

    @Query("SELECT *FROM product")
    fun getAllProducts(): LiveData<List<DetailResponse>>

    @Delete
    suspend fun deleteProduct(product: DetailResponse)
}
