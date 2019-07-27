package <%= packageName %>.handler

import io.vertx.ext.web.RoutingContext

/**
 * Handler implementations for versioning.
 */
object VersionHandler {

    private const val CONTENT_TYPE_HEADER = "Content-Type"

    private const val JSON_CONTENT_TYPE = "application/json; charset=UTF-8"

    private const val VERSION = "{\"version\": \"1.0.0\"}"

    fun version(routingContext: RoutingContext) {
        routingContext.response()
            .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
            .setStatusCode(200)
            .end(VERSION)
    }

}
