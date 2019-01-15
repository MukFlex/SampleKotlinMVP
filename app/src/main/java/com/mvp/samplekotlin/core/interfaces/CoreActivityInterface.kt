package com.tipher.core.interfaces

import android.view.View

/**
 * It is basic structure of activity
 * It provide modular structure to activity
 */
interface CoreActivityInterface {
    //pass resourceId of layout
    fun setLayoutResource(): Int

    //set values to view
    fun setValues()

    // pass array of view on which click event is trigger
    fun registerClickListener(): Array<View>?

    // set toolbarId
    fun setToolbarId(): View?

    //Manage intent values
    fun getIntentValues()
}
