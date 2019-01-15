package com.mvp.samplekotlin.di.module

import android.arch.persistence.room.Room

import com.mvp.samplekotlin.application.MyApplication
import com.mvp.samplekotlin.data.database.AppDatabase
import com.mvp.samplekotlin.data.database.LocalDatabaseSource
import com.mvp.samplekotlin.data.database.basket.BasketDao
import com.mvp.samplekotlin.data.database.datasource.BasketDataSource
import com.mvp.samplekotlin.data.database.category.CategoryDao
import com.mvp.samplekotlin.data.database.datasource.CategoryDataSource
import com.mvp.samplekotlin.data.database.product.ProductDao
import com.mvp.samplekotlin.data.database.datasource.ProductDataSource


import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    private val DATABASE_NAME = "DB_NAME"

    @Singleton
    @Provides
    fun provideDatabase(mApplication: MyApplication): AppDatabase {
        return Room.databaseBuilder(mApplication.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }


    @Singleton
    @Provides
    fun provideProductDao(mCacheDatabase: AppDatabase): ProductDao {
        return mCacheDatabase.productDao()
    }

    @Singleton
    @Provides
    fun provideBasketDao(mCacheDatabase: AppDatabase): BasketDao {
        return mCacheDatabase.basketDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(mCacheDatabase: AppDatabase): CategoryDao {
        return mCacheDatabase.categoryDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDataSource(mCategoryDao: CategoryDao): CategoryDataSource {
        return CategoryDataSource(mCategoryDao)
    }

    @Singleton
    @Provides
    fun provideBasketDataSource(mBasketDao: BasketDao): BasketDataSource {
        return BasketDataSource(mBasketDao)
    }

    @Singleton
    @Provides
    fun provideProductDataSource(mProductDao: ProductDao): ProductDataSource {
        return ProductDataSource(mProductDao)
    }

    @Singleton
    @Provides
    fun provideCacheDatabase(mBasketDataSource: BasketDataSource, mCategoryDataSource: CategoryDataSource, mProductDataSource: ProductDataSource): LocalDatabaseSource {
        return LocalDatabaseSource(mBasketDataSource, mCategoryDataSource, mProductDataSource)
    }


}
