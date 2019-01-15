package com.mvp.samplekotlin.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import com.mvp.samplekotlin.R


/**
 * Created by Atendra on 12/01/2019.
 *
 * Create custom image view
 */

class RoundRectCornerImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : android.support.v7.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private val path = Path()
    private var cornerRadius: Int = 0
    private var roundedCorners: Int = 0

    init {

        val a = context.obtainStyledAttributes(attrs, R.styleable.RoundRectCornerImageView)
        cornerRadius = a.getDimensionPixelSize(R.styleable.RoundRectCornerImageView_cornerRadius, 0)
        roundedCorners = a.getInt(R.styleable.RoundRectCornerImageView_roundedCorners, CORNER_NONE)
        a.recycle()
    }

    fun setCornerRadius(radius: Int) {
        if (cornerRadius != radius) {
            cornerRadius = radius
            setPath()
            invalidate()
        }
    }

    fun getCornerRadius(): Int {
        return cornerRadius
    }

    fun setRoundedCorners(corners: Int) {
        if (roundedCorners != corners) {
            roundedCorners = corners
            setPath()
            invalidate()
        }
    }

    fun isCornerRounded(corner: Int): Boolean {
        return roundedCorners and corner == corner
    }

    override fun onDraw(canvas: Canvas) {
        if (!path.isEmpty) {
            canvas.clipPath(path)
        }

        super.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setPath()
    }

    private fun setPath() {
        path.rewind()

        if (cornerRadius >= 1f && roundedCorners != CORNER_NONE) {
            val radii = FloatArray(8)

            for (i in 0..3) {
                if (isCornerRounded(CORNERS[i])) {
                    radii[2 * i] = cornerRadius.toFloat()
                    radii[2 * i + 1] = cornerRadius.toFloat()
                }
            }

            path.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()),
                    radii, Path.Direction.CW)
        }
    }

    companion object {

        val CORNER_NONE = 0
        val CORNER_TOP_LEFT = 1
        val CORNER_TOP_RIGHT = 2
        val CORNER_BOTTOM_RIGHT = 4
        val CORNER_BOTTOM_LEFT = 8
        val CORNER_ALL = 15

        private val CORNERS = intArrayOf(CORNER_TOP_LEFT, CORNER_TOP_RIGHT, CORNER_BOTTOM_RIGHT, CORNER_BOTTOM_LEFT)
    }
}