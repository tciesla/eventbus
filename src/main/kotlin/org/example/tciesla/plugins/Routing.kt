package org.example.tciesla.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.example.tciesla.routes.eventRouting

fun Application.configureRouting() {
    routing {
        eventRouting()
    }
}