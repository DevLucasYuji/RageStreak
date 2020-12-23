package com.ragestreak.activity

import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.ragestreak.R
import com.ragestreak.commons.BaseActivity

class NavigationActivity : BaseActivity() {
    override val layoutRes: Int
        get() = R.layout.activity_navigation

    override var navigationViewId: Int? = R.id.bottomNavigation

    lateinit var toolbar: Toolbar

    lateinit var toolbarTitle: TextView

    override fun initView() {
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.toolbar_title)
    }
}