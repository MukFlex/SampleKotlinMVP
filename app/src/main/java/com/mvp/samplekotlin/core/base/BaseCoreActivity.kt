package com.mvp.samplekotlin.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.mvp.samplekotlin.application.MyApplication
import com.mvp.samplekotlin.di.component.AppComponent
import com.mvp.samplekotlin.di.component.DaggerPresenterComponent
import com.mvp.samplekotlin.di.component.PresenterComponent
import com.mvp.samplekotlin.di.module.ActivityModule
import com.mvp.samplekotlin.utils.common.ClickUtils
import com.mvp.samplekotlin.utils.common.KeyboardUtils
import com.tipher.core.interfaces.CoreActivityInterface

abstract class BaseCoreActivity : AppCompatActivity(), View.OnClickListener, CoreActivityInterface {
    private var mToolbar: Toolbar? = null
    private var mActionbar: ActionBar? = null
    private lateinit var presenterComponent: PresenterComponent
    lateinit var mActivity: Activity
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mLayoutId = setLayoutResource()
        initializeContextValues()
        if (mLayoutId != -1)
            setContentView(mLayoutId)
        initializeDependencyInjector()
        getIntentValues()

        val toolbar: View? = setToolbarId();
        if (toolbar != null)
            setToolbar(toolbar)
        setValues()
        val viewList = registerClickListener()
        if (viewList != null && viewList.size > 0) {
            // register click listener to views
            ClickUtils.setClickListener(viewList, mContext)
        }
//        }

    }

    /*
    *Initialize context value
     */
    private fun initializeContextValues() {
        mActivity = this
        mContext = this


    }

    /**
     * Pass id of toolbar
     * Attach toolbar to actionbar
     */
    private fun setToolbar(toolbarId: Int) {
        mToolbar = findViewById(toolbarId) as Toolbar
        setSupportActionBar(mToolbar)
        mActionbar = supportActionBar
        mActionbar?.setDisplayShowTitleEnabled(false);
    }

    /**
     * Attach toolbar to actionbar
     */
    private fun setToolbar(toolbar: View) {
        mToolbar = toolbar as Toolbar;
        setSupportActionBar(mToolbar)
        mActionbar = supportActionBar
        mActionbar?.setDisplayShowTitleEnabled(false);
    }

    /**
     * return instance of toolbar
     */
    public fun getToolbarInstance(): Toolbar? {
        return mToolbar;
    }

    /**
     * return instance of Actionbar
     */
    public fun getActionbarInstance(): ActionBar? {
        return mActionbar;
    }

    /**
     * Hide keyboard after click
     */
    override fun onClick(v: View?) {
        KeyboardUtils.hideSoftKeyboard(mActivity)
    }

    /*override fun onDestroy() {
        KeyboardUtils.hideSoftKeyboard(mActivity)
        super.onDestroy()

    }*/

    override fun getIntentValues() {

    }


    private fun initializeDependencyInjector() {
        this.getApplicationComponent().inject(this)
        this.presenterComponent = DaggerPresenterComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build()


    }

    /**
     * Get the Main Application component for dependency injection.
     */
    fun getApplicationComponent(): AppComponent {
        return (application as MyApplication).getAppComponent()
    }

    /**
     * Get an Activity module for dependency injection.
     */
    fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }

    /**
     * Get an Presenter module for dependency injection.
     */
    fun getPresenterComponent(): PresenterComponent {
        return presenterComponent
    }
}