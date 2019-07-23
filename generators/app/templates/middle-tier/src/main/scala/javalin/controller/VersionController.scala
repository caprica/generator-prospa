package <%= packageName %>.controller

import io.javalin.http.{Context, Handler}

/**
  * An example web service API controller.
  */
object VersionController {

    var version: Handler = (ctx: Context) => ctx.json("{\"version\": \"1.0.0\"}")

}
