package <%= packageName %>.service

import java.util.stream.Collectors

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.Message
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

import <%= packageName %>.domain.User
import <%= packageName %>.repository.UserRepository

/**
 * Business service dealing with Users.
 */
class UserService extends AbstractVerticle {

    private final UserRepository userRepository

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository

    }

    void start() {
        vertx.eventBus().consumer("users.all").handler(this.&users)
        vertx.eventBus().consumer("users.one").handler(this.&user)
    }

    private void users(Message<Object> message) {
        List<User> users = userRepository.readUsers()
        // We manually construct an array of JSON objects from the list since Json.encode would do some escaping of
        // quote characters that we don't want - an alternative would be to create a wrapper object the for list (but at
        // least with streams this is not so bad)
        message.reply(new JsonArray(users
            .stream()
            .map(JsonObject.&mapFrom)
            .collect(Collectors.toList())
        ))
    }

    private void user(Message<Object> message) {
        String username = message.body().toString()
        Optional<User> optionalUser = userRepository.readUser(username)
        if (optionalUser.isPresent()) {
            message.reply(JsonObject.mapFrom(optionalUser.get()))
        } else {
            message.fail(404, "No such user")
        }
    }

}
