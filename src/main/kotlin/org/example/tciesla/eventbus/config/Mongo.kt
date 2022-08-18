package org.example.tciesla.eventbus.config

import com.mongodb.ConnectionString
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

private val mongoClient = KMongo.createClient(ConnectionString(
    System.getenv("MONGO_URL") ?: "mongodb://root:test123@localhost"
))

val mongoDatabase: MongoDatabase = mongoClient.getDatabase("eventbus")
