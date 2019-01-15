package com.mvp.samplekotlin.data.database.datasource

import com.mvp.samplekotlin.data.database.DataSource
import com.mvp.samplekotlin.data.database.product.ProductDao
import com.mvp.samplekotlin.data.model.Product

import javax.inject.Inject

class ProductDataSource @Inject
constructor(private val mProductDao: ProductDao) : DataSource<Product> {
    override fun addItem(item: Product) {

    }

    override fun addItems(items: List<Product>) {

    }

    override fun updateItem(item: Product) {

    }

    override fun updateItems(item: List<Product>) {

    }

    override fun removeData(item: Product) {

    }

    override fun hasData(): Boolean {
        return false
    }
}
