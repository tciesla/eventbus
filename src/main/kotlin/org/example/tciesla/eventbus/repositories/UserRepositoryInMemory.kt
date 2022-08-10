package org.example.tciesla.eventbus.repositories

import org.example.tciesla.eventbus.plugins.REALM_FULL
import org.example.tciesla.eventbus.plugins.getMD5Digest

const val USERNAME1 = "user1"
const val USERNAME2 = "user2"
const val PASSWORD1 = "password1"
const val PASSWORD2 = "password2"

val userTable = mapOf(
    USERNAME1 to getMD5Digest("$USERNAME1:$REALM_FULL:$PASSWORD1"),
    USERNAME2 to getMD5Digest("$USERNAME2:$REALM_FULL:$PASSWORD2"),
)

object UserRepositoryInMemory : UserRepository {
    override fun findCredentials(username: String): ByteArray? {
        return userTable[username]
    }
}