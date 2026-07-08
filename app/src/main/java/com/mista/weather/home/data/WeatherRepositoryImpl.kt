package com.mista.weather.home.data

import com.mista.weather.home.data.remote.WeatherApiService
import com.mista.weather.home.domain.Weather

class WeatherRepositoryImpl(
    private val api: WeatherApiService,
) : WeatherRepository {
    override suspend fun getCurrentWeather(lat: Double, lon: Double): Weather =
        api.getCurrentWeather(lat = lat, lon = lon).toDomain()
}
