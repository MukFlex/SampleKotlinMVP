package com.mvp.samplekotlin.view.custom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import com.mvp.samplekotlin.R


/**
 * Created by Amardeep on 7/21/2016.
 * The class describe the custom implementation of the button
 */

/**
 * xmlns:fontpath="http://schemas.android.com/apk/res-auto"
 *
 *
 * <com.walkenhorst.customViews.CustomButton android:layout_width="wrap_content" android:layout_height="@dimen/dimen_30dp" fontpath:customFontbtn="fonts/Helvetica_Light.ttf"></com.walkenhorst.customViews.CustomButton>
 *
 *
 * For font File -- packagename-assests-fonts
 */
class CustomButton : android.support.v7.widget.AppCompatButton {

    /**
     * @param context refer to the context
     */
    constructor(context: Context) : super(context) {}

    /**
     * @param context refer to the context
     * @param attrs   the attributes to be applied
     */
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setCustomFont(context, attrs)
    }

    /**
     * @param context  refer to the context
     * @param attrs    the attributes to be applied
     * @param defStyle the style to be applied
     */
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        setCustomFont(context, attrs)
    }

    /**
     * @param ctx   refer to the context
     * @param attrs the attributes to be applied
     */
    private fun setCustomFont(ctx: Context, attrs: AttributeSet) {
        val a = ctx.obtainStyledAttributes(attrs, R.styleable.MyFont)
        val customFont = a.getString(R.styleable.MyFont_customFont)
        setCustomFont(ctx, customFont)
        a.recycle()
    }

    /**
     * @param ctx   refer to the context
     * @param asset the asset to be applied
     * @return returns a boolean value
     */
    fun setCustomFont(ctx: Context, asset: String?): Boolean {
        val tf: Typeface
        try {
            tf = Typeface.createFromAsset(ctx.assets, asset)
        } catch (e: Exception) {
            return false
        }

        typeface = tf
        return true
    }


}
