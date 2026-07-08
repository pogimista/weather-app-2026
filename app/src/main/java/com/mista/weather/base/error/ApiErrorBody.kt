package com.mista.weather.base.error

import com.squareup.moshi.Json

data class ApiErrorBody(
    @Json(name = "message") val message: String? = null,
    @Json(name = "error") val error: String? = null,
    @Json(name = "code") val code: String? = null,
    @Json(name = "detail") val detail: String? = null,
    @Json(name = "errors") val errors: List<String>? = null,
    @Json(name = "status") val status: Int? = null,
) {
    val displayMessage: String?
        get() = message ?: error ?: detail ?: errors?.firstOrNull()
}
