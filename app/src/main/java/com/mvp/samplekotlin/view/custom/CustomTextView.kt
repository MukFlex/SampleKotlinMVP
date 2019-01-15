package com.mvp.samplekotlin.view.custom

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView
import com.mvp.samplekotlin.R


/**
 * Created by Atendra on 12/01/2019.
 */
@SuppressLint("AppCompatCustomView")
class CustomTextView : TextView {


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

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        return super.dispatchTouchEvent(event)
    }
}
