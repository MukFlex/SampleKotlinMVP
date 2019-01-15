package com.mvp.samplekotlin.core.base

import android.app.Activity
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.View
import com.mvp.samplekotlin.R
import com.mvp.samplekotlin.utils.common.KeyboardUtils


class BaseActionbarUtils {
    companion object {
        /**
         * It used to change the  visibility of actionbar title
         */
        fun setActionbarTitleVisibility(mActionbar: ActionBar?, isVisible: Boolean) {
            mActionbar?.setDisplayShowTitleEnabled(isVisible);
        }

        /**
         * It used to change the  visibility of actionbar navigation icon/humburger icon
         */
        fun setActionbarHomeEnable(mActionbar: ActionBar?, isEnable: Boolean) {
            mActionbar?.setDisplayHomeAsUpEnabled(isEnable)
            mActionbar?.setDisplayShowHomeEnabled(isEnable)
        }

        /**
         * It is use to change the title of actionbar
         */
        fun setTitleOfActionBar(mActionbar: ActionBar?, titleStr: String) {
            mActionbar?.setTitle(titleStr);
            setActionbarTitleVisibility(mActionbar, true)
        }

        /**
         * This method is use to change the navigation icon
         */
        fun changeHomeIndicatorIcon(mActionbar: ActionBar?, resourceId: Int) {
            mActionbar?.setHomeAsUpIndicator(resourceId)
        }

        /**
         * This method is use to set  drawer listener to slidingMenu/NavigationDrawer
         */
        public fun drawerLayoutMethod(mActivity: Activity, drawerLayout: DrawerLayout, mToolbar: Toolbar?) {

            val mDrawerToggle = ActionBarDrawerToggle(
                    mActivity, drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            mDrawerToggle.syncState()


        }

        /**
         * This method is use to set  drawer listener to slidingMenu/NavigationDrawer
         *
         */
        public fun drawerLayoutMethodWithListener(mActivity: Activity, drawerLayout: DrawerLayout, mToolbar: Toolbar?) {
            /*------------------Alternate way to set DrawerListener-------*/

            val mDrawerToggle = object : ActionBarDrawerToggle(
                    mActivity,
                    drawerLayout,
                    mToolbar,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close
            ) {

                /** Called when a drawer has settled in a completely closed state.  */
                override fun onDrawerClosed(view: View) {
                    super.onDrawerClosed(view)
                    KeyboardUtils.hideSoftKeyboard(mActivity)
                }

                /** Called when a drawer has settled in a completely open state.  */
                override fun onDrawerOpened(drawerView: View) {
                    super.onDrawerOpened(drawerView)
                    KeyboardUtils.hideSoftKeyboard(mActivity)

                }

            }

            drawerLayout.addDrawerListener(mDrawerToggle)
            mDrawerToggle.syncState()
        }

        /**
         * This method is used to set custom drawer listener to navigationDrawer/SlidingMenu
         */
        public fun registerDrawerListener(drawerLayout: DrawerLayout, drawerListener: DrawerLayout.DrawerListener) {
            drawerLayout.addDrawerListener(drawerListener)

        }

        /**
         * It is sample of drawerListener
         */
        public fun drawerStateListener(mActivity: Activity): DrawerLayout.DrawerListener {
            return object : DrawerLayout.DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                }

                override fun onDrawerClosed(drawerView: View) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                }

                override fun onDrawerOpened(drawerView: View) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                }

                override fun onDrawerStateChanged(newState: Int) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    KeyboardUtils.hideSoftKeyboard(mActivity)
                }
            }

        }

    }
}