package org.example.tciesla.eventbus.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.tciesla.eventbus.eventRepository
import org.example.tciesla.eventbus.models.Event

fun Route.eventRouting() {

    route("/") {
        get {
            val events = eventRepository.findAll()
            call.respond(events)
        }
        post {
            val event = call.receive<Event>()
            eventRepository.save(event)
            call.respond(HttpStatusCode.Created)
        }
    }
}