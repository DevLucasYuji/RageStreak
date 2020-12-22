package com.ragestreak.home.fragment

import androidx.lifecycle.Observer
import com.ragestreak.commons.BaseFragment
import com.ragestreak.commons.extension.navigate
import com.ragestreak.commons.modules.RequireInject
import com.ragestreak.home.R
import com.ragestreak.home.databinding.FragmentHomeBinding
import com.ragestreak.home.homeModules
import com.ragestreak.home.viewmodel.HomeViewModel
import com.ragestreak.home.viewmodel.states.HomeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(), RequireInject {

    private val viewModel by viewModel<HomeViewModel>()

    override fun getModules() = homeModules

    override val layoutRes: Int
        get() = R.layout.fragment_home

    override fun afterViews() {
        viewModel.init()
        viewModel.viewEvent.observe(this, Observer { event ->
            when(event) {
                is HomeEvent.NavigateToWelcome -> navigate(com.ragestreak.R.id.welcomeFragment)
            }
        })
    }
}