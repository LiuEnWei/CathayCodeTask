package com.wayne.cathaycodetask.model

sealed class Result<T> {
    companion object {
        fun <T> loading(): Result<T> {
            return Loading()
        }

        fun <T> success(result: T?): Result<T> {
            return Success(result)
        }

        fun <T> error(throwable: Throwable): Result<T> {
            return Error(throwable)
        }
    }

    data class Success<T>(val result: T?): Result<T>()
    data class Error<T>(val throwable: Throwable): Result<T>()
    class Loading<T> : Result<T>()
}