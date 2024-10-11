package com.github.andreyjpeg

import jakarta.validation.valueextraction.ExtractedValue
import jakarta.validation.valueextraction.UnwrapByDefault
import jakarta.validation.valueextraction.ValueExtractor

@UnwrapByDefault
class MaybeValueExtractor : ValueExtractor<@ExtractedValue Maybe<*>> {
    override fun extractValues(originalValue: Maybe<*>, receiver: ValueExtractor.ValueReceiver) {
        if (originalValue is Some) {
            receiver.value(null, originalValue.value)
        }
    }
}

@UnwrapByDefault
class SomeValueExtractor : ValueExtractor<@ExtractedValue Some<*>> {
    override fun extractValues(originalValue: Some<*>, receiver: ValueExtractor.ValueReceiver) {
        receiver.value(null, originalValue.value)
    }
}

@UnwrapByDefault
class NoneValueExtractor : ValueExtractor<@ExtractedValue None> {
    override fun extractValues(originalValue: None?, receiver: ValueExtractor.ValueReceiver) {
        // Nothing
    }
}