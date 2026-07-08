package com.mista.weather.home.data.remote.dto

import com.squareup.moshi.Json

data class WeatherResponseDto(
    @Json(name = "name") val name: String,
    @Json(name = "weather") val weather: List<WeatherConditionDto> = emptyList(),
    @Json(name = "main") val main: MainDto,
    @Json(name = "wind") val wind: WindDto? = null,
    @Json(name = "sys") val sys: SysDto? = null,
    @Json(name = "dt") val dt: Long = 0L,
    @Json(name = "timezone") val timezone: Long = 0L,
)

data class WeatherConditionDto(
    @Json(name = "main") val main: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String,
)

data class MainDto(
    @Json(name = "temp") val temp: Double,
    @Json(name = "feels_like") val feelsLike: Double,
    @Json(name = "temp_min") val tempMin: Double,
    @Json(name = "temp_max") val tempMax: Double,
    @Json(name = "pressure") val pressure: Int,
    @Json(name = "humidity") val humidity: Int,
)

data class WindDto(
    @Json(name = "speed") val speed: Double,
)

data class SysDto(
    @Json(name = "country") val country: String? = null,
    @Json(name = "sunrise") val sunrise: Long = 0L,
    @Json(name = "sunset") val sunset: Long = 0L,
)
