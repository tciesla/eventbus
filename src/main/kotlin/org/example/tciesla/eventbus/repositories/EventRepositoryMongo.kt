package org.example.tciesla.eventbus.repositories

import com.mongodb.ConnectionString
import org.example.tciesla.eventbus.models.Event
import org.litote.kmongo.KMongo

object EventRepositoryMongo : EventRepository {

    private val MONGO_USERNAME = System.getenv("MONGO_USERNAME") ?: "root"
    private val MONGO_PASSWORD = System.getenv("MONGO_PASSWORD") ?: "test123"
    private val MONGO_HOST = System.getenv("MONGO_HOST") ?: "localhost"

    private val mongoClient = KMongo.createClient(ConnectionString("mongodb://$MONGO_USERNAME:$MONGO_PASSWORD@$MONGO_HOST"))
    private val database = mongoClient.getDatabase("eventbus")
    private val eventCollection = database.getCollection("events", Event::class.java)

    override fun save(event: Event) {
        eventCollection.insertOne(event)
    }

    override fun findAll(): List<Event> {
        return eventCollection.find().toList()
    }
}