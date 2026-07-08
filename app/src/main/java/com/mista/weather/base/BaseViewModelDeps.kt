package com.mista.weather.base

import android.app.Application
import com.mista.weather.session.CacheSession
import com.mista.weather.session.TransientSession
import com.squareup.moshi.Moshi

data class BaseViewModelDeps(
    val application: Application,
    val cacheSession: CacheSession,
    val transientSession: TransientSession,
    val moshi: Moshi,
    val screenResultBus: ScreenResultBus,
)
