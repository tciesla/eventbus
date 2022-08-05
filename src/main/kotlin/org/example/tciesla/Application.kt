package org.example.tciesla

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.example.tciesla.plugins.configureRouting
import org.example.tciesla.plugins.configureSerialization

fun main(args: Array<String>) {
    EngineMain.main(args)
}

// resources/application.conf
fun Application.module() {
    configureRouting()
    configureSerialization()
}
