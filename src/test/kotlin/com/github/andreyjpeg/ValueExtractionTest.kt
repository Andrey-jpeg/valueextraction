package com.github.andreyjpeg

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class ValueExtractionTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @field:Client("/")
    lateinit var httpClient: HttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun canSerialize() {
        val request = HttpRequest.POST("/", String::class.java)
            .body(
                """
                  {
                      "world": "world"
                  }
                    """.trimIndent(),
            )

        val response = httpClient.toBlocking().exchange(request, String::class.java)
    }
}
