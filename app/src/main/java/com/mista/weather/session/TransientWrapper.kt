package com.mista.weather.session

class TransientWrapper<T> : CacheWrapper<T> {
    override var value: T? = null

    override fun clear() {
        value = null
    }
}
