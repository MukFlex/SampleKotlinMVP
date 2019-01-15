package com.mvp.samplekotlin.utils.common


import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * This class is used to manage hide and show of keyboard
 */
object KeyboardUtils {
    /** Hide keyboard
     * @param activity
     */
    fun hideSoftKeyboard(activity: Activity) {
        try {
            val focusedView = activity.currentFocus
            if (focusedView != null) {
                val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(focusedView.windowToken, 0)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**Show keyboard
     * @param view
     */
    fun showSoftKeyboard(view: View) {
        try {
            val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            view.requestFocus()
            inputMethodManager.showSoftInput(view, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


}

