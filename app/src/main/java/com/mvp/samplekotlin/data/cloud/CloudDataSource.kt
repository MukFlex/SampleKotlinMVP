package com.mvp.samplekotlin.data.cloud

import android.util.Log
import com.mvp.samplekotlin.data.model.login.Login
import com.google.gson.Gson
import com.mvp.samplekotlin.BuildConfig
import com.mvp.samplekotlin.data.cloud.exception.CloudException
import com.mvp.samplekotlin.data.model.Product
import com.mvp.samplekotlin.data.wrappers.BaseResponse
import com.mvp.samplekotlin.data.wrappers.Message
import io.reactivex.Observable
import javax.inject.Inject

class CloudDataSource @Inject constructor(private val mCloudApi: CloudApi) : CloudRepository {


    private val TAG = CloudDataSource::class.java.name
//    private lateinit var mCloudApi: CloudApi


    fun <T> interceptError(response: BaseResponse<T>): Observable<T> {

        if (BuildConfig.showHttpLog) {
            try {
                Log.v(TAG, Gson().toJson(response.get()))
                Log.v(TAG, response.code?.toString())
            } catch (x: Exception) {

            } catch (r: Error) {

            }

        }
        /**
         * uncomment, if webservices manage with status code,  error message
         */
        /*  if (response.code != 200) {
              val m = Message()
              m.code = response.code
              m.text = response.status
              m.data = response.get()
              return Observable.error(CloudException(m))
          }*/


        return Observable.just(response.get())
    }

    private fun <T> interceptTagError(response: T): Observable<T> {

        if (BuildConfig.showHttpLog) {
            try {
                Log.v(TAG, Gson().toJson(response))
            } catch (x: Exception) {

            } catch (r: Error) {

            }

        }

        return Observable.just(response)
    }

    //    override fun getAllCloudProducts(): Observable<Product> {
//        mCloudApi.getAllCloudProducts().flatMap(this::interceptError<Any> )
//    }
    override fun getAllCloudProducts(): Observable<Product> {
        return mCloudApi.getAllCloudProducts().flatMap {
            interceptError(it)

        }
    }

    override fun postLogin(params: HashMap<String, String>): Observable<Login> {
        return mCloudApi.postLogin(params).flatMap { it: BaseResponse<Login> -> interceptError(it) }
    }

}