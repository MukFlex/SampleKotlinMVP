package com.mvp.samplekotlin.data.database


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.mvp.samplekotlin.data.database.basket.BasketDao
import com.mvp.samplekotlin.data.database.basket.BasketEntity
import com.mvp.samplekotlin.data.database.category.CategoryDao
import com.mvp.samplekotlin.data.database.category.CategoryEntity
import com.mvp.samplekotlin.data.database.product.ProductDao
import com.mvp.samplekotlin.data.database.product.ProductEntity

@Database(entities =[ProductEntity::class, CategoryEntity::class, BasketEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao
    abstract fun basketDao(): BasketDao

}
