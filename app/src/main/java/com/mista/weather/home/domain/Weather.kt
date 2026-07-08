package com.mista.weather.home.domain

data class Weather(
    val cityName: String,
    val country: String?,
    val temperature: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val humidity: Int,
    val pressure: Int,
    val windSpeed: Double,
    val condition: String,
    val description: String,
    val iconCode: String,
    val sunrise: Long,
    val sunset: Long,
    val observedAt: Long,
    val timezoneOffsetSeconds: Long,
)

/** True when it's past 6 PM local time at the weather's location. */
val Weather.isPastSixPm: Boolean
    get() {
        val localSecondsOfDay = (observedAt + timezoneOffsetSeconds).mod(86_400L)
        return localSecondsOfDay / 3600 >= 18
    }
