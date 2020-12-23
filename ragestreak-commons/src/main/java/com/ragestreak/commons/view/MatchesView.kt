package com.ragestreak.commons.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.ragestreak.commons.R

class MatchesView : AppCompatButton {

    private lateinit var paint: Paint
    private lateinit var rect: RectF

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    init {
        paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = (background as? ColorDrawable)?.color ?: ContextCompat.getColor(
                context,
                R.color.colorAccent
            )
            style = Paint.Style.STROKE
            strokeWidth = 10F
            isAntiAlias = false
        }
        rect = RectF()
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val minDimen = widthMeasureSpec.coerceAtMost(heightMeasureSpec)
        setMeasuredDimension(minDimen, minDimen)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val strokeWidth = 10
        val minDimen = width.coerceAtMost(height)
        val left = (strokeWidth / 2).toFloat()
        val top = (strokeWidth / 2).toFloat()
        val right: Float = (minDimen - strokeWidth / 2).toFloat()
        val bottom: Float = (minDimen - strokeWidth / 2).toFloat()
        rect.set(left, top, right, bottom)
        canvas?.drawArc(rect, 2F, 360F, true, paint)
    }
}