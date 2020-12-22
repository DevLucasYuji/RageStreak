package com.ragestreak.activity

import com.ragestreak.R
import com.ragestreak.commons.BaseActivity

class NavigationActivity : BaseActivity() {
    override val layoutRes: Int
        get() = R.layout.activity_navigation

    override var navigationViewId: Int? = R.id.bottomNavigation

    override fun initView() {

    }
}