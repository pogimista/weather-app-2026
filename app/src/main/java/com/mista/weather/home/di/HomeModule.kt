package com.mista.weather.home.di

import com.mista.weather.home.data.WeatherHistoryRepository
import com.mista.weather.home.data.WeatherHistoryRepositoryImpl
import com.mista.weather.home.data.WeatherRepository
import com.mista.weather.home.data.WeatherRepositoryImpl
import com.mista.weather.home.data.location.LocationProvider
import com.mista.weather.home.data.location.LocationProviderImpl
import com.mista.weather.home.data.remote.WeatherApiService
import com.mista.weather.home.domain.GetCurrentWeatherUseCase
import com.mista.weather.home.domain.GetDeviceLocationUseCase
import com.mista.weather.home.presentation.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {
    single { get<Retrofit>().create(WeatherApiService::class.java) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
    single<WeatherHistoryRepository> { WeatherHistoryRepositoryImpl(get(), get()) }
    single<LocationProvider> { LocationProviderImpl(androidApplication()) }
    factory { GetCurrentWeatherUseCase(get()) }
    factory { GetDeviceLocationUseCase(get()) }
    viewModelOf(::HomeViewModel)
}
