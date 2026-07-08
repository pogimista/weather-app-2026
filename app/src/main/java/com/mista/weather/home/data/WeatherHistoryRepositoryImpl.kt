package com.mista.weather.home.data

import android.content.SharedPreferences
import com.mista.weather.home.domain.Weather
import com.mista.weather.home.domain.WeatherHistoryEntry
import com.mista.weather.session.PersistentCacheWrapper
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class WeatherHistoryRepositoryImpl(
    sharedPreferences: SharedPreferences,
    moshi: Moshi,
) : WeatherHistoryRepository {

    private val cache = PersistentCacheWrapper<List<WeatherHistoryEntry>>(
        sharedPreferences = sharedPreferences,
        key = KEY_WEATHER_HISTORY,
        type = Types.newParameterizedType(List::class.java, WeatherHistoryEntry::class.java),
        moshi = moshi,
    )

    override fun getHistory(): List<WeatherHistoryEntry> = cache.value.orEmpty()

    override fun addEntry(weather: Weather) {
        val now = System.currentTimeMillis()
        val entry = WeatherHistoryEntry(id = now, fetchedAt = now, weather = weather)
        cache.value = (listOf(entry) + getHistory()).take(MAX_ENTRIES)
    }

    private companion object {
        const val KEY_WEATHER_HISTORY = "key_weather_history"
        const val MAX_ENTRIES = 30
    }
}
