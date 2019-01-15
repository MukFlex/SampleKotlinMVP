package com.mvp.samplekotlin.data.cloud


import com.mvp.samplekotlin.data.model.login.Login
import com.mvp.samplekotlin.data.model.Product
import com.mvp.samplekotlin.data.wrappers.BaseResponse

import io.reactivex.Observable
import retrofit2.http.*


interface CloudApi {

    @GET("api/products")
    fun getAllCloudProducts(): Observable<BaseResponse<Product>>

    @FormUrlEncoded
    @Headers("USER-ID: 619", "Accept-Language: english", "OAUTH-TOKEN: MjA=_61e749a9669d92fe7026e255c478629c", "X-API-KEY: VEIp4AWImE", "Authorization: Basic dmlwZ3JvdXA6MTIzNDU2")
    @POST("users/login")
    fun postLogin(@FieldMap params: HashMap<String, String>): Observable<BaseResponse<Login>>
}
