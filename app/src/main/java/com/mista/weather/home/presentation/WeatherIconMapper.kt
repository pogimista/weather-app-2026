package com.mista.weather.home.presentation

fun weatherEmoji(condition: String): String = when (condition.lowercase()) {
    "clear" -> "☀️"
    "clouds" -> "☁️"
    "rain" -> "🌧️"
    "drizzle" -> "🌦️"
    "thunderstorm" -> "⛈️"
    "snow" -> "❄️"
    "mist", "fog", "haze", "smoke" -> "🌫️"
    "dust", "sand", "ash" -> "🏜️"
    "squall", "tornado" -> "🌪️"
    else -> "🌡️"
}
