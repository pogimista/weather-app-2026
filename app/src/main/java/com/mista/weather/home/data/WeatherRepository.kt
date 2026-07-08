package com.mista.weather.home.data

import com.mista.weather.home.domain.Weather

interface WeatherRepository {
    suspend fun getCurrentWeather(lat: Double, lon: Double): Weather
}
