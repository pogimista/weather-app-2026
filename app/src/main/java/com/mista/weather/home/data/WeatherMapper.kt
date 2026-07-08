package com.mista.weather.home.data

import com.mista.weather.home.data.remote.dto.WeatherResponseDto
import com.mista.weather.home.domain.Weather

fun WeatherResponseDto.toDomain(): Weather {
    val condition = weather.firstOrNull()
    return Weather(
        cityName = name,
        country = sys?.country,
        temperature = main.temp,
        feelsLike = main.feelsLike,
        tempMin = main.tempMin,
        tempMax = main.tempMax,
        humidity = main.humidity,
        pressure = main.pressure,
        windSpeed = wind?.speed ?: 0.0,
        condition = condition?.main.orEmpty(),
        description = condition?.description.orEmpty(),
        iconCode = condition?.icon.orEmpty(),
    )
}
