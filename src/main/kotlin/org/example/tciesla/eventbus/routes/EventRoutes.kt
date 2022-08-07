package org.example.tciesla.eventbus.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.tciesla.eventbus.models.Event

fun Route.eventRouting() {

    val eventsInMemory = mutableListOf<Event>()

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