package org.example.tciesla

import com.google.gson.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.OffsetDateTime
import java.util.*

fun main() {
    println("event-bus")

    val exampleEvents = listOf(
        Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload1"),
        Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload2"),
        Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload3")
    )

    val gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeConverter()).create()

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText( gson.toJson(exampleEvents), ContentType.Application.Json)
            }
        }
    }.start(wait = true)
}
