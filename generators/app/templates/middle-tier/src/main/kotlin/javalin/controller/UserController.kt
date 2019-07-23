package <%= packageName %>.controller

import io.javalin.http.Context

import <%= packageName %>.domain.User
import <%= packageName %>.service.UserServiceImpl

/**
 * An example web service API controller.
 */
object UserController {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userService = UserServiceImpl()

    val users: (Context)->Unit = { ctx ->
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        ctx.json(userService.users())
    }

    val user: (Context)->Unit = { ctx ->
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        val user: User? = userService.user(ctx.pathParam("username"))
        if (user != null) ctx.json(user) else ctx.status(404)
    }

}
