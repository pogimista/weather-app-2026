package com.mista.weather.base

import com.mista.weather.base.error.AppError
import com.mista.weather.base.error.toAppError

abstract class BaseUseCase<in Params, out Result> {

    protected abstract suspend fun execute(params: Params): Result

    suspend operator fun invoke(params: Params): kotlin.Result<Result> = try {
        kotlin.Result.success(execute(params))
    } catch (e: AppError) {
        kotlin.Result.failure(e)
    } catch (e: Exception) {
        kotlin.Result.failure(e.toAppError())
    }

    object NoParams
}
