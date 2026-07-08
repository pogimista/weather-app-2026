package com.mista.weather.home.domain

data class WeatherHistoryEntry(
    val id: Long,
    val fetchedAt: Long,
    val weather: Weather,
)
