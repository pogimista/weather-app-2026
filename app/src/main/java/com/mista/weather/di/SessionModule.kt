package com.mista.weather.di

import android.content.Context
import com.mista.weather.base.BaseViewModelDeps
import com.mista.weather.base.ScreenResultBus
import com.mista.weather.session.CacheSession
import com.mista.weather.session.TransientSession
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sessionModule = module {
    single {
        androidContext().getSharedPreferences("session_prefs", Context.MODE_PRIVATE)
    }
    single { TransientSession() }
    single { ScreenResultBus() }
    single { CacheSession(get(), get(), get()) }
    single {
        BaseViewModelDeps(
            application = androidApplication(),
            cacheSession = get(),
            transientSession = get(),
            moshi = get(),
            screenResultBus = get(),
        )
    }
}
