package org.example.tciesla.eventbus

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.example.tciesla.eventbus.plugins.configureRouting
import org.example.tciesla.eventbus.plugins.configureSerialization
import org.example.tciesla.eventbus.repositories.EventRepository
import org.example.tciesla.eventbus.repositories.EventRepositoryMongo

lateinit var eventRepository: EventRepository

fun main(args: Array<String>) {
    EngineMain.main(args)
}

// resources/application.conf
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureStorage()
}

fun configureStorage() {
    eventRepository = EventRepositoryMongo
}
