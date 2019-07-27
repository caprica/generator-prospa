package <%= packageName %>

import io.javalin.Javalin

import <%= packageName %>.controller.UserController
import <%= packageName %>.controller.VersionController

object <%= mainClassName %> {

    @JvmStatic
    fun main(args: Array<String>) {
        val app = Javalin.create()
            .get("/api/users", UserController.users)
            .get("/api/users/:username", UserController.user)
            .get("/api/version", VersionController.version)
            .get("/api/*") { ctx -> ctx.status(400) }                  // Any unmapped API will result in a 400 Bad Request

        app.config
            .addStaticFiles("/app")                                    // The front-end application
            .addStaticFiles("/")                                       // Other static assets, external to the front-end application
            .addSinglePageRoot("/", "/app/index.html")                 // Catch-all route for the single-page application

        app.start(<%= serverPort %>)
    }

}
