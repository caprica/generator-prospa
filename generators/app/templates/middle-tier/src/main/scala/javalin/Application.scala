package <%= packageName %>

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import io.javalin.Javalin
import io.javalin.plugin.json.JavalinJackson

import <%= packageName %>.controller.{UserController, VersionController}

object Application {

    def main(args: Array[String]): Unit = {
        // Explicit configuration of a Jackson ObjectMapper is required to enable JSON marshalling for Scala classes
        val objectMapper = new ObjectMapper()
        objectMapper.registerModule(DefaultScalaModule)
        JavalinJackson.configure(objectMapper)

        val app = Javalin.create
            .get("/api/users", UserController.users)
            .get("/api/users/:username", UserController.user)
            .get("/api/*", (ctx) => ctx.status(400))           // Any unmapped API will result in a 400 Bad Request
            .get("version", VersionController.version)

        app.config
            .addStaticFiles("/app")                            // The ReactJS application
            .addStaticFiles("/")                               // Other static assets, external to the ReactJS application
            .addSinglePageRoot("/", "/app/index.html")       // Catch-all route for the single-page application

        app.start(<%= serverPort %>)
    }

}
