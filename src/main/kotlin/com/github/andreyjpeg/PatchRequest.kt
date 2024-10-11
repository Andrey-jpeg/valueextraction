package com.github.andreyjpeg

import io.micronaut.core.annotation.Introspected
import jakarta.validation.constraints.NotNull

@Introspected
data class PatchRequest(
    val world: Maybe<@NotNull String>
)
