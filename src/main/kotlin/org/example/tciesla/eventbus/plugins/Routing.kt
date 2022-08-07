package org.example.tciesla.eventbus.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.example.tciesla.eventbus.routes.eventRouting

fun Application.configureRouting() {
    routing {
        eventRouting()
    }
}