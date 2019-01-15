package com.mvp.samplekotlin.mvp.view


import com.mvp.samplekotlin.data.cloud.exception.CloudException

/**
 * Created by grestuccia on 10/24/16.
 */

interface LoginView : BaseView {

    fun loginOnSuccess()
    fun loginOnError(e: CloudException)
    //    void saveLoginAccess(Login login);



    fun forgotOnSuccess()
    fun forgotOnError(error: CloudException)


}
