package org.example.tciesla.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.tciesla.models.Event
import java.time.OffsetDateTime
import java.util.*

fun Route.eventRouting() {

    val eventsInMemory = mutableListOf<Event>(
        Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload1"),
        Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload2"),
        Event(UUID.randomUUID(), OffsetDateTime.now(), "somePayload3")
    )

    route("/") {
        get {
            call.respond(eventsInMemory)
        }
        post {
            val event = call.receive<Event>()
            eventsInMemory.add(event)
            call.respond(HttpStatusCode.Created)
        }
    }
}