package com.tipher.core.interfaces

import android.view.View

/**
 * Created by Mukesh on 6/15/2017.
 *
 * It is basic structure of fragment
 *
 */
interface CoreFragmentInterface {
    // set layout to fragment
    fun setLayoutResource(): Int

    //set values
    fun setValues()

    //Pass list of view to register clik listener
    fun registerClickListener(): Array<View>?

    //Manage values of Intent
    fun getIntentValues()
}