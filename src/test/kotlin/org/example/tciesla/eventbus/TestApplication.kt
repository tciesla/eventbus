package org.example.tciesla.eventbus

import io.ktor.server.application.*
import io.ktor.server.auth.*
import org.example.tciesla.eventbus.plugins.*
import org.example.tciesla.eventbus.repositories.EventRepositoryInMemory
import org.example.tciesla.eventbus.repositories.UserRepositoryInMemory

// resources/application.conf
fun Application.test() {
    configureRouting()
    configureSerialization()
    configureAuthentication()
    configureStorage()
}

fun Application.configureAuthentication() {
    userRepository = UserRepositoryInMemory

    install(Authentication) {
        digest(AUTHENTICATION_DIGEST) {
            realm = REALM_FULL
            digestProvider { userName, _ -> userRepository.findCredentials(userName) }
        }
    }
}

fun configureStorage() {
    eventRepository = EventRepositoryInMemory
}