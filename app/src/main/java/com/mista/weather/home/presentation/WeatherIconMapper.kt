package com.mista.weather.home.presentation

import com.mista.weather.home.domain.Weather
import com.mista.weather.home.domain.isPastSixPm
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

private val RAIN_CONDITIONS = setOf("rain", "drizzle")

/** Sun/rain/moon (and a few extra) icon per condition, using a moon instead of a sun past 6 PM. */
fun weatherEmoji(condition: String, isPastSixPm: Boolean): String {
    val normalized = condition.lowercase()
    return when {
        normalized == "clear" && isPastSixPm -> "🌙"
        normalized == "clear" -> "☀️"
        normalized in RAIN_CONDITIONS -> "🌧️"
        normalized == "thunderstorm" -> "⛈️"
        normalized == "clouds" -> "☁️"
        normalized == "snow" -> "❄️"
        normalized in setOf("mist", "fog", "haze", "smoke") -> "🌫️"
        normalized in setOf("dust", "sand", "ash") -> "🏜️"
        normalized in setOf("squall", "tornado") -> "🌪️"
        else -> "🌡️"
    }
}

fun weatherEmoji(weather: Weather): String = weatherEmoji(weather.condition, weather.isPastSixPm)

/** Formats a UTC epoch-seconds timestamp as HH:mm local time at the given location offset. */
fun formatLocalTime(epochSeconds: Long, timezoneOffsetSeconds: Long): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    return formatter.format(Date((epochSeconds + timezoneOffsetSeconds) * 1000))
}
