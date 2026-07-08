package com.mista.weather.base.error

import com.squareup.moshi.Moshi
import retrofit2.HttpException
import java.io.IOException

sealed class AppError(cause: Throwable? = null) : Exception(cause) {
    class Network(cause: Throwable? = null) : AppError(cause)
    data class Http(val code: Int, val errorBody: String? = null) : AppError() {
        fun toApiErrorBody(moshi: Moshi): ApiErrorBody? = errorBody?.let {
            runCatching { moshi.adapter(ApiErrorBody::class.java).fromJson(it) }.getOrNull()
        }
    }
    class Unexpected(cause: Throwable? = null) : AppError(cause)
}

fun Throwable.toAppError(): AppError = when (this) {
    is AppError -> this
    is IOException -> AppError.Network(this)
    is HttpException -> {
        val body = try {
            response()?.errorBody()?.string()?.takeIf { it.isNotBlank() }
        } catch (e: Exception) {
            null
        }
        AppError.Http(code(), body)
    }
    else -> AppError.Unexpected(this)
}
