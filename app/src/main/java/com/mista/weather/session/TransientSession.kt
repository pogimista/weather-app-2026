package com.mista.weather.session

class TransientSession {

    var userId: CacheWrapper<Int> = TransientWrapper()
    var searchHistory: CacheWrapper<List<String>> = TransientWrapper()

    fun clearAll() {
        userId.clear()
        searchHistory.clear()
    }
}
