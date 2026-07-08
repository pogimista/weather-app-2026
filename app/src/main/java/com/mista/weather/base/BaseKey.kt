package com.mista.weather.base

import androidx.fragment.app.Fragment
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey

abstract class BaseKey : DefaultFragmentKey() {
    open val animation: NavigationAnimation get() = NavigationAnimation.Slide
    public abstract override fun instantiateFragment(): Fragment
}
