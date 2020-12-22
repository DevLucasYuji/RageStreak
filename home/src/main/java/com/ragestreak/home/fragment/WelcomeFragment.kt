package com.ragestreak.home.fragment

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ragestreak.commons.BaseFragment
import com.ragestreak.commons.extension.navigate
import com.ragestreak.home.R
import com.ragestreak.home.databinding.FragmentWelcomeBinding
import com.ragestreak.home.viewmodel.WelcomeViewModel
import com.ragestreak.home.viewmodel.states.WelcomeEvent
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    private val viewModel by viewModel<WelcomeViewModel>()

    override val layoutRes: Int
        get() = R.layout.fragment_welcome

    override fun afterViews() {
        binding.viewModel = viewModel
        viewModel.viewEvent.observe(this, Observer { event ->
            when (event) {
                WelcomeEvent.UserIsReady -> navigate(com.ragestreak.R.id.homeFragment)
            }
        })
    }
}