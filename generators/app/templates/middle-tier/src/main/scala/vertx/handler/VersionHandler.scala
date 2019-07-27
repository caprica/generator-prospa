package <%= packageName %>.handler

import io.vertx.core.AsyncResult
import io.vertx.core.eventbus.Message
import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext

/**
  * Handler implementations for versioning.
  */
object VersionHandler {

    private val CONTENT_TYPE_HEADER = "Content-Type"

    private val JSON_CONTENT_TYPE = "application/json; charset=UTF-8"

    private val VERSION = "{\"version\": \"1.0.0\"}"

    def version(routingContext: RoutingContext): Unit = {
        routingContext.response
            .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
            .setStatusCode(200)
            .end(Json.encode(VERSION))
    }

}
