package com.github.andreyjpeg

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.validation.Valid

@Controller
class MaybeController {

    @Post
    fun hello(@Valid @Body body: PatchRequest) {
        println(body.world)
    }
}