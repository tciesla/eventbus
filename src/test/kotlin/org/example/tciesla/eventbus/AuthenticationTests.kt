package org.example.tciesla.eventbus

import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import org.example.tciesla.eventbus.plugins.REALM_FULL
import org.example.tciesla.eventbus.repositories.PASSWORD
import org.example.tciesla.eventbus.repositories.USERNAME
import kotlin.test.Test
import kotlin.test.assertEquals

private const val SOME_ENDPOINT = "/"

class AuthenticationTests {

    @Test
    fun `should return 401(unauthorized) without authentication`() = testApplication {
        // given
        val client = withContentNegotiationOnly()
        // when
        val response = client.get(SOME_ENDPOINT)
        // then
        assertEquals(HttpStatusCode.Unauthorized, response.status)
    }

    @Test
    fun `should return 401(unauthorized) when failure authentication (incorrect username)`() = testApplication {
        // given
        val client = withAuthentication(USERNAME + "typo", PASSWORD)
        // when
        val response = client.get(SOME_ENDPOINT)
        // then
        assertEquals(HttpStatusCode.Unauthorized, response.status)
    }

    @Test
    fun `should return 401(unauthorized) when failure authentication (incorrect password)`() = testApplication {
        // given
        val client = withAuthentication(USERNAME, PASSWORD + "typo")
        // when
        val response = client.get(SOME_ENDPOINT)
        // then
        assertEquals(HttpStatusCode.Unauthorized, response.status)
    }

    @Test
    fun `should return 200(ok) when successful authentication`() = testApplication {
        // given
        val client = withAuthentication(USERNAME, PASSWORD)
        // when
        val response = client.get(SOME_ENDPOINT)
        // then
        assertEquals(HttpStatusCode.OK, response.status)
    }

    private fun ApplicationTestBuilder.withContentNegotiationOnly() = client.config {
        install(ContentNegotiation) { json() }
    }

    private fun ApplicationTestBuilder.withAuthentication(username: String, password: String) = client.config {
        install(ContentNegotiation) { json() }
        install(Auth) {
            digest {
                realm = REALM_FULL
                credentials {
                    DigestAuthCredentials(username, password)
                }
            }
        }
    }
}