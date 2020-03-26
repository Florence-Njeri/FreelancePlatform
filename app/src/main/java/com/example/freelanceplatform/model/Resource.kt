package com.example.freelanceplatform.model

/**
 * This class will handle our loading, success, and failure from
 * asynchronous operation.
 */
sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val throwable: Throwable) : Resource<T>()
}