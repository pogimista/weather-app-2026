package com.mista.weather.session

interface CacheWrapper<T> {
    var value: T?
    fun clear()
}
