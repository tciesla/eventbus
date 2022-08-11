package org.example.tciesla.eventbus.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import org.example.tciesla.eventbus.repositories.UserRepository
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

const val REALM_FULL = "full"
const val AUTHENTICATION_DIGEST = "auth-digest"

lateinit var userRepository: UserRepository

fun Application.configureAuthentication() {
    install(Authentication) {
        digest(AUTHENTICATION_DIGEST) {
            realm = REALM_FULL
            digestProvider { userName, _ -> userRepository.findCredentials(userName) }
        }
    }
}

fun getMD5Digest(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
