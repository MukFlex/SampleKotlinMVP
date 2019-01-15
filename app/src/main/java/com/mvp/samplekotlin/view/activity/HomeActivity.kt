package com.mvp.samplekotlin.view.activity

import android.view.View
import com.mvp.samplekotlin.R
import com.mvp.samplekotlin.core.base.BaseActivity

class HomeActivity:BaseActivity(){
    override fun setCoordinatorLayout(): View? {
        return null
    }

    override fun setLayoutResource(): Int {
     return R.layout.activity_main
    }

    override fun setValues() {

    }

    override fun registerClickListener(): Array<View>? {
        return null
    }

    override fun setToolbarId(): View? {
       return null
    }

}