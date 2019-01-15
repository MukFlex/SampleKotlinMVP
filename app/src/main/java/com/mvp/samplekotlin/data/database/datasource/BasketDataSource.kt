package com.mvp.samplekotlin.data.database.datasource

import com.mvp.samplekotlin.data.database.DataSource
import com.mvp.samplekotlin.data.database.basket.BasketDao
import com.mvp.samplekotlin.data.database.basket.BasketEntity
import com.mvp.samplekotlin.data.database.category.CategoryEntity

import javax.inject.Inject

class BasketDataSource @Inject
constructor(private val mBasketDao: BasketDao) : DataSource<BasketEntity> {
    override fun addItem(item: BasketEntity) {

    }

    override fun addItems(items: List<BasketEntity>) {

    }

    override fun updateItem(item: BasketEntity) {

    }

    override fun updateItems(item: List<BasketEntity>) {

    }

    override fun removeData(item: BasketEntity) {

    }

    override fun hasData(): Boolean {
        return false
    }


}
