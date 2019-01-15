package com.mvp.samplekotlin.data.database

import com.mvp.samplekotlin.data.model.Product

import io.reactivex.Observable

interface DatabaseRepository {


    fun  getAllCachedProducts(): Observable<Product>?
    /*--------------------No use of instance in Repository--------*/
    //    BasketDataSource basketData();

    //    CategoryDataSource categoryData();

    //    ProductDataSource productData();
}
