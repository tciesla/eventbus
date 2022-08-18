package org.example.tciesla.eventbus

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.example.tciesla.eventbus.plugins.configureAuthentication
import org.example.tciesla.eventbus.plugins.configureRouting
import org.example.tciesla.eventbus.plugins.configureSerialization
import org.example.tciesla.eventbus.plugins.userRepository
import org.example.tciesla.eventbus.repositories.EventRepository
import org.example.tciesla.eventbus.repositories.EventRepositoryMongo
import org.example.tciesla.eventbus.repositories.UserRepositoryMongo

lateinit var eventRepository: EventRepository

fun main(args: Array<String>) {
    EngineMain.main(args)
}

@Suppress("unused") // resources/application.yaml
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureStorage()
    configureAuthentication()
}

fun configureStorage() {
    userRepository = UserRepositoryMongo
    eventRepository = EventRepositoryMongo
}
