package com.mista.weather.home.presentation

import androidx.fragment.app.Fragment
import com.mista.weather.base.BaseKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeKey(private val id: Int = 0) : BaseKey() {
    override fun instantiateFragment(): Fragment = HomeFragment()
}
