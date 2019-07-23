package <%= packageName %>.controller;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Optional;

import <%= packageName %>.domain.User;
import <%= packageName %>.service.UserService;
import <%= packageName %>.service.UserServiceImpl;

/**
 * An example web service API controller.
 */
public class UserController {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private static UserService userService = new UserServiceImpl();

    public static Handler users = ctx -> {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        ctx.json(userService.users());
    };

    public static Handler user = ctx -> {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        userService.user(ctx.pathParam("username")).ifPresentOrElse(ctx::json, () -> ctx.status(404));
    };

}
