package com.mvp.samplekotlin.data.factory

import com.mvp.samplekotlin.data.model.login.Login
import com.mvp.samplekotlin.data.cloud.CloudDataSource
import com.mvp.samplekotlin.data.cloud.CloudRepository
import com.mvp.samplekotlin.data.database.DatabaseRepository
import com.mvp.samplekotlin.data.database.LocalDatabaseSource
import com.mvp.samplekotlin.data.model.Product

import javax.inject.Inject

import io.reactivex.Observable

class DataSourceFactory @Inject
constructor(private val mCloudSource: CloudDataSource, private val mCacheSource: LocalDatabaseSource) : DatabaseRepository, CloudRepository {
    override fun postLogin(params: HashMap<String, String>): Observable<Login> {
    return  mCloudSource.postLogin(params)
    }

    override fun getAllCloudProducts(): Observable<Product> {
        return mCloudSource.getAllCloudProducts()
    }

    override fun getAllCachedProducts(): Observable<Product>? {
        return mCacheSource.getAllCachedProducts()
    }


}
