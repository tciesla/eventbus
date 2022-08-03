import java.time.OffsetDateTime
import java.util.*

data class Event(
    val eventUUID: UUID,
    val timestamp: OffsetDateTime,
    val payload: String
)
