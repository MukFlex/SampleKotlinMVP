package com.mvp.samplekotlin.utils.common

import android.app.Activity
import android.content.Context
import android.view.View


object ClickUtils {
    /**
     * Register click listener on array of views
     * It is use for Activity
     */
    fun setClickListener(clickIDs: IntArray, context: Context) {
        if (context is View.OnClickListener) {
            for (id in clickIDs) {
                val view = (context as Activity).findViewById<View>(id)
                view.setOnClickListener(context)
                ClickGuard.guard(view)
            }
        }
    }

    /**
     * Register click listener on array of views
     * It is use for Activity/fragment/dialog
     */
    fun setClickListener(clickIDs: IntArray, listener: View.OnClickListener, rootView: View) {

        for (id in clickIDs) {
            val view = rootView.findViewById<View>(id)
            view.setOnClickListener(listener)
            ClickGuard.guard(view)
        }

    }

    /**
     * Register click listener on array of views
     * It is use for Activity/fragment/dialog
     */
    fun setClickListener(clickIDs: IntArray, context: Context, rootView: View) {
        if (context is View.OnClickListener) {
            for (id in clickIDs) {
                val view = rootView.findViewById<View>(id)
                view.setOnClickListener(context)
                ClickGuard.guard(view)
            }
        }
    }

    /**
     * Register click listener on array of views
     * It is use for Activity/fragment
     */
    fun setClickListener(views: Array<View>, context: Context) {
        if (context is View.OnClickListener) {
            for (view in views) {
                view.setOnClickListener(context)
                ClickGuard.guard(view)
            }
        }
    }

    /**
     * Register click listener on array of views
     *
     */
    fun setClickListener(views: Array<View>, listener: View.OnClickListener) {

        for (view in views) {
            view.setOnClickListener(listener)
            ClickGuard.guard(view)
        }

    }


}
