package org.example.tciesla.eventbus

import io.ktor.server.application.*
import org.example.tciesla.eventbus.plugins.configureRouting
import org.example.tciesla.eventbus.plugins.configureSerialization
import org.example.tciesla.eventbus.repositories.EventRepositoryInMemory

// resources/application.conf
fun Application.test() {
    configureRouting()
    configureSerialization()
    configureStorage()
}

fun configureStorage() {
    eventRepository = EventRepositoryInMemory
}
