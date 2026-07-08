package com.mista.weather.home.data.location

import com.mista.weather.home.domain.Coordinates

interface LocationProvider {
    /** Returns the device's current coordinates, or null if permission/location is unavailable. */
    suspend fun getCurrentLocation(): Coordinates?
}
