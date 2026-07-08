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
)
