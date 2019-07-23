package <%= packageName %>.handler

import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext

/**
 * Handler implementations for dealing with Users.
 */
object UserHandler {

    private const val CONTENT_TYPE_HEADER = "Content-Type"

    private const val JSON_CONTENT_TYPE = "application/json; charset=UTF-8"

    fun users(routingContext: RoutingContext) {
        // Simulate a delay
        try {
            Thread.sleep(1000)
        } catch (e: Exception) {
        }

        routingContext.vertx().eventBus().send<Any>("users.all", null) { result ->
            if (result.succeeded()) {
                routingContext.response()
                    .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                    .setStatusCode(200)
                    .end(Json.encode(result.result().body()))
            } else {
                routingContext.response().setStatusCode(500).end()
            }
        }
    }

    fun user(routingContext: RoutingContext) {
        // Simulate a delay
        try {
            Thread.sleep(1000)
        } catch (e: Exception) {
        }

        val username = routingContext.request().getParam("username")
        routingContext.vertx().eventBus().send<Any>("users.one", username) { result ->
            if (result.succeeded()) {
                routingContext.response()
                    .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                    .setStatusCode(200)
                    .end(Json.encode(result.result().body()))
            } else {
                routingContext.response()
                        .setStatusCode(404)
                        .end()
            }
        }
    }

}
