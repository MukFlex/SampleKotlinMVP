package com.mvp.samplekotlin.mvp.presenter

import android.app.Activity
import com.mvp.samplekotlin.data.model.login.Login

import com.mvp.samplekotlin.data.factory.DataSourceFactory
import com.mvp.samplekotlin.mvp.view.LoginView
import com.mvp.samplekotlin.utils.common.ErrorConvert

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


import java.util.HashMap

import javax.inject.Inject

class LoginPresenterImpl @Inject
constructor(private val dataSource: DataSourceFactory, private val mActivity: Activity) : LoginPresenter {

    private val TAG = LoginPresenterImpl::class.java.name
    private lateinit var mLoginView: LoginView
    private val mCompositeDisposable = CompositeDisposable()
    override fun doLogin(email: String, password: String) {
        mLoginView?.showLoadingIndicator()
        val body = HashMap<String, String>()
        body["email"] = email
        body["password"] = password
        body["latitude"] = "28.6185753"
        body["longitude"] = "77.3906657"
        body["device_token"] = ""
        body["device_type_id"] = "1"
        body["lang_id"] = "1"
        dataSource?.postLogin(body).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = {
                            //                            println(it)
                            saveLoginAccess(it)
                            mLoginView?.hideLoadingIndicator()
                            mLoginView?.loginOnSuccess()
                        },
                        onError = {
                            //                            it.printStackTrace()

                            mLoginView?.hideLoadingIndicator()
                            mLoginView?.loginOnError(ErrorConvert.convert2CloudException(it))
                        },
                        onComplete = {
                            println("Done!")
                        }


                )
    }

    override fun doForgotPassword(email: String) {

    }

    override fun saveLoginAccess(login: Login?) {

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        mCompositeDisposable?.clear()
    }

    override fun setView(view: LoginView) {
        this.mLoginView = view
    }
}


