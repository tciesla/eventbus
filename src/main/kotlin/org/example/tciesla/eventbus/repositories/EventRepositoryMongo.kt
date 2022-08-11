package org.example.tciesla.eventbus.repositories

import org.example.tciesla.eventbus.config.mongoDatabase
import org.example.tciesla.eventbus.models.Event

object EventRepositoryMongo : EventRepository {

    private val eventCollection = mongoDatabase.getCollection("events", Event::class.java)

    override fun save(event: Event) {
        eventCollection.insertOne(event)
    }

    override fun findAll(): List<Event> {
        return eventCollection.find().toList()
    }
}