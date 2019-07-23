package <%= packageName %>.controller

import io.javalin.http.{Context, Handler}

import <%= packageName %>.service.UserServiceImpl

/**
  * An example web service API controller.
  */
object UserController {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userService = new UserServiceImpl

    var users: Handler = (ctx: Context) => {
        // Add a fake delay so we can see state changes in the UI
        Thread.sleep(1000)

        ctx.json(userService.users)
    }

    var user: Handler = (ctx: Context) => {
        // Add a fake delay so we can see state changes in the UI
        Thread.sleep(1000)

        userService.user(ctx.pathParam("username")) match {
            case Some(user) => ctx.json(user)
            case None => ctx.status(404)
        }
    }

}
