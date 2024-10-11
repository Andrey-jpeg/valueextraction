package com.github.andreyjpeg

/**
 * Wraps any value
 */
sealed class Maybe<out T>

data class Some<out T>(val value: T) : Maybe<T>() {
    companion object {
        fun <T> none(): Maybe<T> = None
    }
}

data object None : Maybe<Nothing>()