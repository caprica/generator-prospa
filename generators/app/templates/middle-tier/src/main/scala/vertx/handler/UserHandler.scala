package <%= packageName %>.handler

import io.vertx.core.AsyncResult
import io.vertx.core.eventbus.Message
import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext

/**
  * Handler implementations for dealing with Users.
  */
object UserHandler {

    private val CONTENT_TYPE_HEADER = "Content-Type"
    private val JSON_CONTENT_TYPE = "application/json; charset=UTF-8"

    def users(routingContext: RoutingContext): Unit = {
        // Simulate a delay
        try Thread.sleep(1000)
        catch {
            case _: Exception =>
        }

        routingContext.vertx.eventBus.send("users.all", null, (result: AsyncResult[Message[AnyRef]]) => {
            if (result.succeeded) {
                routingContext.response
                    .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                    .setStatusCode(200)
                    .end(Json.encode(result.result.body))
            } else {
                routingContext.response
                    .setStatusCode(500).end()
            }
        })
    }

    def user(routingContext: RoutingContext): Unit = {
        // Simulate a delay
        try Thread.sleep(1000)
        catch {
            case _: Exception =>
        }

        val username = routingContext.request.getParam("username")
        routingContext.vertx.eventBus.send("users.one", username, (result: AsyncResult[Message[AnyRef]]) => {
            if (result.succeeded) {
                routingContext.response
                    .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                    .setStatusCode(200)
                    .end(Json.encode(result.result.body))
            } else {
                routingContext.response
                    .setStatusCode(404).end()
            }
        })
    }

}
