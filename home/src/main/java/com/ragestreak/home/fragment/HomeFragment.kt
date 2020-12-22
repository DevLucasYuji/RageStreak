package com.ragestreak.home.fragment

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ragestreak.commons.BaseFragment
import com.ragestreak.commons.modules.RequireInject
import com.ragestreak.home.R
import com.ragestreak.home.homeModules
import com.ragestreak.home.viewmodel.HomeViewModel
import com.ragestreak.home.viewmodel.states.HomeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(), RequireInject {

    private val viewModel by viewModel<HomeViewModel>()

    override fun getModules() = homeModules

    override val layoutRes: Int
        get() = R.layout.fragment_home

    override fun afterViews() {
        viewModel.init()
        viewModel.viewEvent.observe(this, Observer { event ->
            when(event) {
                is HomeEvent.NavigateToWelcome -> {
                    findNavController().navigate(com.ragestreak.R.id.welcomeFragment)
                }
            }
        })
    }
}