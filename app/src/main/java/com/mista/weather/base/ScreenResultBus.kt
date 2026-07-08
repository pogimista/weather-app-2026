package com.mista.weather.base

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class ScreenResultBus {
    private val _results = MutableSharedFlow<ScreenResult<*>>(extraBufferCapacity = 1)
    val results: SharedFlow<ScreenResult<*>> = _results.asSharedFlow()

    suspend fun emit(result: ScreenResult<*>) {
        _results.emit(result)
    }
}
