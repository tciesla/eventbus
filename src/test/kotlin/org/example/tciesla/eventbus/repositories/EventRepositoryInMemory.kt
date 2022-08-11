package org.example.tciesla.eventbus.repositories

import org.example.tciesla.eventbus.models.Event

object EventRepositoryInMemory : EventRepository {

    private val eventsInMemory = mutableListOf<Event>()

    @Synchronized
    override fun save(event: Event) {
        eventsInMemory.add(event)
    }

    @Synchronized
    override fun findAll(): List<Event> {
        return eventsInMemory
    }
}