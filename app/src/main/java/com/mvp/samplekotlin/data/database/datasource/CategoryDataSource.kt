package com.mvp.samplekotlin.data.database.datasource

import com.mvp.samplekotlin.data.database.DataSource
import com.mvp.samplekotlin.data.database.basket.BasketDao
import com.mvp.samplekotlin.data.database.category.CategoryDao
import com.mvp.samplekotlin.data.database.category.CategoryEntity

import javax.inject.Inject

class CategoryDataSource @Inject
constructor(private val mCategoryDao: CategoryDao) : DataSource<CategoryEntity> {
    override fun addItem(item: CategoryEntity) {

    }

    override fun addItems(items: List<CategoryEntity>) {

    }

    override fun updateItem(item: CategoryEntity) {

    }

    override fun updateItems(item: List<CategoryEntity>) {

    }

    override fun removeData(item: CategoryEntity) {

    }

    override fun hasData(): Boolean {
        return false
    }


}