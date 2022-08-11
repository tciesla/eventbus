package org.example.tciesla.eventbus.models

import kotlinx.serialization.Serializable

@Serializable
class User(val username: String, val credentials: ByteArray)