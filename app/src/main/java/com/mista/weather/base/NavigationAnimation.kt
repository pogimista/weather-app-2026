package com.mista.weather.base

import androidx.annotation.AnimRes
import com.mista.weather.R

sealed class NavigationAnimation {

    internal data class Anims(
        @AnimRes val enter: Int,
        @AnimRes val exit: Int,
        @AnimRes val popEnter: Int,
        @AnimRes val popExit: Int,
    )

    internal open fun anims(): Anims? = null

    object None : NavigationAnimation()

    object Slide : NavigationAnimation() {
        override fun anims() = Anims(
            enter    = R.anim.nav_slide_in_right,
            exit     = R.anim.nav_slide_out_left,
            popEnter = R.anim.nav_slide_in_left,
            popExit  = R.anim.nav_slide_out_right,
        )
    }

    object Fade : NavigationAnimation() {
        override fun anims() = Anims(
            enter    = R.anim.nav_fade_in,
            exit     = R.anim.nav_fade_out,
            popEnter = R.anim.nav_fade_in,
            popExit  = R.anim.nav_fade_out,
        )
    }

    object Scale : NavigationAnimation() {
        override fun anims() = Anims(
            enter    = R.anim.nav_scale_in,
            exit     = R.anim.nav_scale_out,
            popEnter = R.anim.nav_scale_in,
            popExit  = R.anim.nav_scale_out,
        )
    }

    object SlideUp : NavigationAnimation() {
        override fun anims() = Anims(
            enter    = R.anim.nav_slide_in_up,
            exit     = R.anim.nav_fade_out,
            popEnter = R.anim.nav_fade_in,
            popExit  = R.anim.nav_slide_out_down,
        )
    }
}
