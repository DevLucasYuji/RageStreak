package com.ragestreak.commons.extension

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(id: Int) {
    this.findNavController().navigate(id)
}
