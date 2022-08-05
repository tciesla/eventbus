package org.example.tciesla.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.tciesla.models.Event
import java.time.OffsetDateTime
import java.util.*

fun Route.eventRouting() {
    route("/") {
        get {
            val exampleEvents = listOf(
                Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload1"),
                Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload2"),
                Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload3")
            )
            call.respond(exampleEvents)
        }
    }
}