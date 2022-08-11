package org.example.tciesla.eventbus.models

import kotlinx.serialization.Serializable
import org.example.tciesla.eventbus.plugins.OffsetDateTimeSerializer
import org.example.tciesla.eventbus.plugins.UUIDSerializer
import java.time.OffsetDateTime
import java.util.*

@Serializable
data class Event(
    @Serializable(UUIDSerializer::class) val eventUUID: UUID,
    @Serializable(OffsetDateTimeSerializer::class) val timestamp: OffsetDateTime,
    val payload: String
)