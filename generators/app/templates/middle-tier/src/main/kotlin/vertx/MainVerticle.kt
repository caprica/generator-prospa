package <%= packageName %>

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler

import <%= packageName %>.handler.UserHandler
import <%= packageName %>.handler.VersionHandler
import <%= packageName %>.repository.MemoryUserRepository
import <%= packageName %>.service.UserService

class <%= mainClassName %> : AbstractVerticle() {

    override fun start(startFuture: Future<Void>) {
        // Configure routes to handlers
        val router = Router.router(vertx)

        // Handlers for our API services
        router.route("/api/users").handler { UserHandler.users(it) }
        router.route("/api/users/:username").handler { UserHandler.user(it) }
        router.route("/api/version").handler { VersionHandler.version(it) }

        // Catch-all for non-existent API routes to return a Bad Request status code
        router.route("/api/*").handler { routingContext -> routingContext.response().setStatusCode(400).end() }

        // ReactJS initial artifacts, e.g. index.html, manifest, favicon etc, and also the ReactJS application's static
        // assets (in the ReactJS application there are in a "/static" sub-directory).
        router.route("/*").handler(StaticHandler.create("app"))

        // Catch-all route, anything unmatched is sent to the SPA main page for client-side routing (we can't just
        // redirect to "/" and use the prior static handler mapping as this would strip the request path required for
        // client-side routing)
        router.get().handler { routingContext -> routingContext.response().sendFile("app/index.html").end() }

        // Register a business service
        vertx.deployVerticle(UserService(MemoryUserRepository()))

        // Create the server
        vertx.createHttpServer().requestHandler(router).listen(<%= serverPort %>) { result ->
            if (result.succeeded()) {
                println("Vert.x server listening on port <%= serverPort %>")
            } else {
                println("Vert.x server failed to start")
                println(result.cause())
            }
        }
    }

}
