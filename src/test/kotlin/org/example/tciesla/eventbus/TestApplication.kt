package org.example.tciesla.eventbus

import io.ktor.server.application.*
import org.example.tciesla.eventbus.plugins.configureAuthentication
import org.example.tciesla.eventbus.plugins.configureRouting
import org.example.tciesla.eventbus.plugins.configureSerialization
import org.example.tciesla.eventbus.plugins.userRepository
import org.example.tciesla.eventbus.repositories.EventRepositoryInMemory
import org.example.tciesla.eventbus.repositories.UserRepositoryInMemory

@Suppress("unused") // resources/application.yaml
fun Application.test() {
    configureRouting()
    configureSerialization()
    configureStorage()
    configureAuthentication()
}

fun configureStorage() {
    userRepository = UserRepositoryInMemory
    eventRepository = EventRepositoryInMemory
}