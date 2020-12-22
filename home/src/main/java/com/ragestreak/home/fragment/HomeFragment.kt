package com.ragestreak.home.fragment

import com.ragestreak.commons.BaseFragment
import com.ragestreak.commons.modules.RequireInject
import com.ragestreak.home.R
import com.ragestreak.home.homeModules
import com.ragestreak.home.viewmodel.HomeViewModel

class HomeFragment: BaseFragment<HomeViewModel>(), RequireInject {

    override fun getModules() = homeModules

    override val layoutRes: Int
        get() = R.layout.activity_home

    override fun afterViews() {
    }
}