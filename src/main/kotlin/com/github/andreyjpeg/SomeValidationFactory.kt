package com.github.andreyjpeg

import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import jakarta.validation.valueextraction.ValueExtractor


@Factory
class SomeValidationFactory {
    @Singleton
    fun maybeValueExtractor(): ValueExtractor<Maybe<*>> {
        return MaybeValueExtractor()
    }

    @Singleton
    fun someValueExtractor(): ValueExtractor<Some<*>> {
        return SomeValueExtractor()
    }

    @Singleton
    fun noneValueExtractor(): ValueExtractor<None> {
        return NoneValueExtractor()
    }
}