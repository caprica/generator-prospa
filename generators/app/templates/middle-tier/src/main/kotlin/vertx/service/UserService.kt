package <%= packageName %>.service

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.Message
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

import <%= packageName %>.domain.User
import <%= packageName %>.repository.UserRepository

/**
 * Business service dealing with Users.
 */
class UserService(private val userRepository: UserRepository) : AbstractVerticle() {

    override fun start() {
        vertx.eventBus().consumer<Any>("users.all").handler { this.users(it) }
        vertx.eventBus().consumer<Any>("users.one").handler { this.user(it) }
    }

    private fun users(message: Message<Any>) {
        val users = userRepository.readUsers()

        // We manually construct an array of JSON objects from the list since Json.encode would do some escaping of
        // quote characters that we don't want - an alternative would be to create a wrapper object the for list (but at
        // least with streams this is not so bad)
        message.reply(JsonArray(users.map { JsonObject.mapFrom(it) }))
    }

    private fun user(message: Message<Any>) {
        val username = message.body().toString()
        val user: User? = userRepository.readUser(username)
        if (user != null) message.reply(JsonObject.mapFrom(user)) else message.fail(404, "No such user")
    }

}
