package <%= packageName %>.handler

import io.vertx.ext.web.RoutingContext

/**
 * Handler implementations for versioning.
 */
class VersionHandler {

    private static final String CONTENT_TYPE_HEADER = "Content-Type"

    private static final String JSON_CONTENT_TYPE = "application/json charset=UTF-8"

    private static final String VERSION = "{\"version\": \"1.0.0\"}"

    static void version(RoutingContext routingContext) {
        routingContext.response()
            .putHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE)
            .setStatusCode(200)
            .end(VERSION)
    }

}
