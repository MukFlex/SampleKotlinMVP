package com.mvp.samplekotlin.data.cloud

import com.mvp.samplekotlin.data.model.login.Login
import com.mvp.samplekotlin.data.model.Product

import io.reactivex.Observable


interface CloudRepository {
    fun getAllCloudProducts(): Observable<Product>
    fun postLogin(params: HashMap<String, String>):Observable<Login>
}
