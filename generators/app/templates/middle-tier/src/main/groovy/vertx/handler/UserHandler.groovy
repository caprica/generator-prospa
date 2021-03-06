package <%= packageName %>.handler

import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext

/**
 * Handler implementations for dealing with Users.
 */
class UserHandler {

    private static final String CONTENT_TYPE_HEADER = "Content-Type"

    private static final String JSON_CONTENT_TYPE = "application/json charset=UTF-8"

    static void users(RoutingContext routingContext) {
        // Simulate a delay
        try {
            Thread.currentThread().sleep(1000)
        }
        catch (Exception ignored) {
        }

        routingContext.vertx().eventBus().send("users.all", null, { result ->
            if (result.succeeded()) {
                routingContext.response()
                    .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
                    .setStatusCode(200)
                    .end(Json.encode(result.result().body()))
            } else {
                routingContext.response().setStatusCode(500).end()
            }
        })
    }

    static void user(RoutingContext routingContext) {
        // Simulate a delay
        try {
            Thread.currentThread().sleep(1000)
        }
        catch (Exception ignored) {
        }

        String username = routingContext.request().getParam("username")
        routingContext.vertx().eventBus().send("users.one", username, { result ->
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
        })
    }

}
