import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    println("event-bus")

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respond(HttpStatusCode.OK, "{}")
            }
        }
    }.start(wait = true)
}