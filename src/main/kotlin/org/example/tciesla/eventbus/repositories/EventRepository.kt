package org.example.tciesla.eventbus.repositories

import org.example.tciesla.eventbus.models.Event

interface EventRepository {
    fun save(event: Event)
    fun findAll(): List<Event>
}