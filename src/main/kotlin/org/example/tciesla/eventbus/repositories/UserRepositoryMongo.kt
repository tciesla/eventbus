package org.example.tciesla.eventbus.repositories

import io.ktor.util.*
import org.example.tciesla.eventbus.config.mongoDatabase
import org.example.tciesla.eventbus.models.User
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

object UserRepositoryMongo : UserRepository {

    private val userCollection = mongoDatabase.getCollection("users", User::class.java)

    override fun findCredentials(username: String): ByteArray? {
        return userCollection.findOne(User::username eq username)?.credentials?.decodeBase64Bytes()
    }
}