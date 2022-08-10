package org.example.tciesla.eventbus.repositories

import com.mongodb.ConnectionString
import org.example.tciesla.eventbus.models.User
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

object UserRepositoryMongo : UserRepository {

    private val MONGO_USERNAME = System.getenv("MONGO_USERNAME") ?: "root"
    private val MONGO_PASSWORD = System.getenv("MONGO_PASSWORD") ?: "test123"
    private val MONGO_HOST = System.getenv("MONGO_HOST") ?: "localhost"

    private val mongoClient = KMongo.createClient(ConnectionString("mongodb://$MONGO_USERNAME:$MONGO_PASSWORD@$MONGO_HOST"))
    private val database = mongoClient.getDatabase("eventbus")
    private val userCollection = database.getCollection("users", User::class.java)

    override fun findCredentials(username: String): ByteArray? {
        return userCollection.findOne(User::username eq username)?.credentials
    }
}