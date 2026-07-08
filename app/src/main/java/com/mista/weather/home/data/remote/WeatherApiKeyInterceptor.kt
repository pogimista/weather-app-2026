package com.mista.weather.home.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class WeatherApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val urlWithApiKey = request.url.newBuilder()
            .addQueryParameter("appid", apiKey)
            .build()
        return chain.proceed(request.newBuilder().url(urlWithApiKey).build())
    }
}
