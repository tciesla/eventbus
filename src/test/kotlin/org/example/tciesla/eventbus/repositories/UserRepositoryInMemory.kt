package org.example.tciesla.eventbus.repositories

import io.ktor.util.*
import org.example.tciesla.eventbus.plugins.REALM_FULL
import org.example.tciesla.eventbus.plugins.getMD5Digest

const val USERNAME = "user1"
const val PASSWORD = "password1"

val userTable = mapOf(
    USERNAME to getMD5Digest("$USERNAME:$REALM_FULL:$PASSWORD").encodeBase64(),
)

object UserRepositoryInMemory : UserRepository {
    override fun findCredentials(username: String): ByteArray? {
        return userTable[username]?.decodeBase64Bytes()
    }
}