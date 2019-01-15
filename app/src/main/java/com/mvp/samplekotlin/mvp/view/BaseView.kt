package com.mvp.samplekotlin.mvp.view

/**
 * Created by grestuccia on 28/12/15.
 */
interface BaseView {
    fun showLoadingIndicator()
    fun hideLoadingIndicator()
    fun showError(e: Throwable)
    fun showToast(msg:String)
}
