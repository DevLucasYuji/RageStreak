package com.ragestreak.home.fragment

import android.view.View
import androidx.lifecycle.Observer
import com.ragestreak.activity.NavigationActivity
import com.ragestreak.commons.BaseFragment
import com.ragestreak.commons.extension.navigate
import com.ragestreak.commons.modules.RequireInject
import com.ragestreak.home.R
import com.ragestreak.home.adapter.RagerPagerAdapter
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
            when (event) {
                is HomeEvent.NavigateToWelcome -> navigate(com.ragestreak.R.id.welcomeFragment)
                is HomeEvent.UserIsReady -> init()
            }
        })
    }

    private fun init() {
        fadeInBottomNavigation()
        initMenu()
        initViewPager()
    }

    private fun initViewPager() {
        val vPager = binding.vPager
        val adapter = RagerPagerAdapter(requireActivity(), listOf())
        vPager.adapter = adapter
    }

    private fun initMenu() {
        (activity as? NavigationActivity)?.apply {
            toolbar.apply {
                setNavigationIcon(R.drawable.ic_menu_icon)
                visibility = View.VISIBLE
                post {
                    inflateMenu(R.menu.menu_home)
                }
            }
            toolbarTitle.text = "Lucas Yuji"
        }
        setHasOptionsMenu(true)
    }
}