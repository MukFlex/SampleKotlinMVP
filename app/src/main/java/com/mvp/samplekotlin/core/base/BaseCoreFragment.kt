package com.mvp.samplekotlin.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvp.samplekotlin.utils.common.ClickUtils
import com.tipher.core.interfaces.CoreFragmentInterface


abstract class BaseCoreFragment : Fragment(), View.OnClickListener, CoreFragmentInterface {


    var mActivity: Activity? = null
    var mContext: Context? = null
    lateinit var baseActivityInstance: BaseActivity
    /**
     * manage to show menu option
     * initialize context
     * getValue from Intent
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        initializeContextValue()
        getIntentValues()
    }

    /**
     * Setup view for fragment
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val mLayoutId: Int = setLayoutResource()
        if (mLayoutId != -1) {
            return inflater.inflate(mLayoutId, container, false)
        }
//
        return null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValues()
        val viewList = registerClickListener();
        if (viewList != null && viewList.isNotEmpty()) {
            ClickUtils.setClickListener(viewList, this)
        }

    }


    override fun getIntentValues() {

    }

    /**
     * initialize context values
     */
    private fun initializeContextValue() {
        mActivity = activity
        mContext = context
        baseActivityInstance = mActivity as BaseActivity
    }

}
