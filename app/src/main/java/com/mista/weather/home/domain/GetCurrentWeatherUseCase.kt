package com.mista.weather.home.domain

import com.mista.weather.base.BaseUseCase
import com.mista.weather.home.data.WeatherRepository

class GetCurrentWeatherUseCase(
    private val repository: WeatherRepository,
) : BaseUseCase<Coordinates, Weather>() {

    override suspend fun execute(params: Coordinates): Weather =
        repository.getCurrentWeather(lat = params.lat, lon = params.lon)
}
