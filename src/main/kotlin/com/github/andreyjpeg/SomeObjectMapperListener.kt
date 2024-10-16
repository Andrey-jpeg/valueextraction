package com.github.andreyjpeg

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import jakarta.inject.Singleton

/**
 * Configures the [ObjectMapper] with support for the [Maybe] type.
 */
@Singleton
class SomeObjectMapperListener : BeanCreatedEventListener<ObjectMapper> {
    override fun onCreated(event: BeanCreatedEvent<ObjectMapper>): ObjectMapper {
        val mapper = event.bean
        mapper.registerMaybeModule()
        return mapper
    }
}