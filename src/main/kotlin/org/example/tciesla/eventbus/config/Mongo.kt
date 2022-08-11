package org.example.tciesla.eventbus.config

import com.mongodb.ConnectionString
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

private val mongoUsername = System.getenv("MONGO_USERNAME") ?: "root"
private val mongoPassword = System.getenv("MONGO_PASSWORD") ?: "test123"
private val mongoHost = System.getenv("MONGO_HOST") ?: "localhost"

private val mongoClient = KMongo.createClient(ConnectionString("mongodb://$mongoUsername:$mongoPassword@$mongoHost"))

val mongoDatabase: MongoDatabase = mongoClient.getDatabase("eventbus")
