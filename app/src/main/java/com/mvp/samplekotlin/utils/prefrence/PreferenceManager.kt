package com.mvp.samplekotlin.utils.prefrence

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject

class PreferenceManager @Inject
constructor(mContext: Context) {

    private val mContext: Context? = null
    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = mContext.getSharedPreferences(PreferenceConstant.APP_PREFERENCE, Context.MODE_PRIVATE)
    }

}
