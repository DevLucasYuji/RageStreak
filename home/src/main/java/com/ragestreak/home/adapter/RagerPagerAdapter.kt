package com.ragestreak.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ragestreak.commons.local.model.Rager
import com.ragestreak.home.fragment.HomeRagerFragment

class RagerPagerAdapter(
    fm: FragmentActivity,
    private val ragers: List<Rager>
    ) : FragmentStateAdapter(fm) {

    override fun getItemCount() = 0

    override fun createFragment(position: Int): Fragment {
        val rager = ragers[position]
        return HomeRagerFragment(rager)
    }
}
