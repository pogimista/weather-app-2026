package com.mista.weather.home.data

import com.mista.weather.home.domain.Weather
import com.mista.weather.home.domain.WeatherHistoryEntry

interface WeatherHistoryRepository {
    fun getHistory(): List<WeatherHistoryEntry>
    fun addEntry(weather: Weather)
}
