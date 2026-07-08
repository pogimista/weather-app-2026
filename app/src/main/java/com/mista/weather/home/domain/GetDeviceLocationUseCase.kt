package com.mista.weather.home.domain

import com.mista.weather.base.BaseUseCase
import com.mista.weather.home.data.location.LocationProvider

class GetDeviceLocationUseCase(
    private val locationProvider: LocationProvider,
) : BaseUseCase<BaseUseCase.NoParams, Coordinates?>() {

    override suspend fun execute(params: NoParams): Coordinates? = locationProvider.getCurrentLocation()
}
