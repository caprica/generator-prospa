package <%= packageName %>.controller

import io.javalin.http.Context

/**
 * An example web service API controller.
 */
object VersionController {

    val version: (Context)->Unit = { ctx -> ctx.json("{\"version\": \"1.0.0\"}") }

}
