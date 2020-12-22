package com.ragestreak.commons.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.ragestreak.commons.R

class Division : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleRes
    )

    init {
        try {
            val color = ContextCompat.getColor(context, R.color.colorAccent)
            setBackgroundColor(color)
        } finally {
            invalidate()
            requestLayout()
        }
    }

}