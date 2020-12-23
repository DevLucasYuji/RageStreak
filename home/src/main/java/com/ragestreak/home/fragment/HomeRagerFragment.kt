package com.ragestreak.home.fragment

import com.ragestreak.commons.BaseFragment
import com.ragestreak.commons.local.model.Rager
import com.ragestreak.home.R
import com.ragestreak.home.databinding.FragmentHomeRagerBinding

class HomeRagerFragment(private val rager: Rager) : BaseFragment<FragmentHomeRagerBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_home_rager

    override fun afterViews() {

    }
}
