package com.mvp.samplekotlin.data.database

import com.mvp.samplekotlin.data.database.datasource.BasketDataSource
import com.mvp.samplekotlin.data.database.datasource.CategoryDataSource
import com.mvp.samplekotlin.data.database.datasource.ProductDataSource
import com.mvp.samplekotlin.data.model.Product

import javax.inject.Inject

import io.reactivex.Observable

class LocalDatabaseSource @Inject
constructor(private val mBasketDataSource: BasketDataSource, private val mCategoryDataSource: CategoryDataSource, private val mProductDataSource: ProductDataSource) : DatabaseRepository {
    override fun getAllCachedProducts(): Observable<Product>? {
        return null
    }

}
