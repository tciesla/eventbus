package org.example.tciesla.eventbus.repositories

interface UserRepository {
    fun findCredentials(username: String): ByteArray?
}