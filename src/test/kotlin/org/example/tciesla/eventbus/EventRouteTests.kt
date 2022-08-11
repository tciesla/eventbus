package org.example.tciesla.eventbus

import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import org.example.tciesla.eventbus.models.Event
import org.example.tciesla.eventbus.plugins.REALM_FULL
import org.example.tciesla.eventbus.repositories.PASSWORD
import org.example.tciesla.eventbus.repositories.USERNAME
import java.time.OffsetDateTime
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class EventRouteTests {

    @Test
    fun `should return empty array when there are no events`() = testApplication {
        // given
        val client = configureClient()
        // when
        val response = client.get("/")
        // then
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("[]", response.bodyAsText())
    }

    @Test
    fun `should return posted event`() = testApplication {
        // given
        val client = configureClient()
        val event = Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload")
        val postResponse = client.post("/") {
            contentType(ContentType.Application.Json)
            setBody(event)
        }
        assertEquals(HttpStatusCode.Created, postResponse.status)

        // when
        val getResponse = client.get("/")

        // then
        assertEquals(HttpStatusCode.OK, getResponse.status)
        assertEquals(
            "[{\"eventUUID\":\"" + event.eventUUID.toString() + "\",\"timestamp\":\""+ event.timestamp.toString() + "\",\"payload\":\"somePayload\"}]",
            getResponse.bodyAsText()
        )
    }

    private fun ApplicationTestBuilder.configureClient() = client.config {
        install(ContentNegotiation) { json() }
        install(Auth) {
            digest {
                realm = REALM_FULL
                credentials {
                    DigestAuthCredentials(username = USERNAME, password = PASSWORD)
                }
            }
        }
    }

}