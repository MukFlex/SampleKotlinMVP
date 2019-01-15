package com.mvp.samplekotlin.data.cloud.util

import com.mvp.samplekotlin.data.cloud.exception.CloudException
import com.mvp.samplekotlin.data.wrappers.Message
import com.mvp.samplekotlin.utils.prefrence.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor: Interceptor {


    @Inject lateinit var mSharedPreference: PreferenceManager

    override fun intercept(chain: Interceptor.Chain): Response? {
        val request = chain.request()
        val response = chain.proceed(request)
        if (!response.isSuccessful) {
            val m = Message()
            m.errorMsg = response.message()
            m.text = response.message()
            m.code = response.code()
            throw CloudException(m)


        }
        return null
    }
}