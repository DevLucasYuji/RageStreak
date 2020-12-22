package com.ragestreak.commons.view

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatButton
import com.ragestreak.commons.R

class Button : AppCompatButton {

    constructor(context: Context) : super(
        ContextThemeWrapper(context, R.style.AppTheme_Button),
        null,
        R.style.AppTheme_Button
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        ContextThemeWrapper(context, R.style.AppTheme_Button),
        attrs,
        R.style.AppTheme_Button
    )

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttrs: Int = R.style.AppTheme_Button
    ) : super(
        ContextThemeWrapper(context, R.style.AppTheme_Button),
        attrs,
        defStyleAttrs
    )

    init {
        try {
            isClickable = true
            isFocusable = true
        } finally {
            invalidate()
            requestLayout()
        }
    }
}