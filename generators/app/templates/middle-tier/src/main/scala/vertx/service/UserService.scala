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
class UserService(val userRepository: UserRepository) extends AbstractVerticle {

    override def start(): Unit = {
        vertx.eventBus.consumer("users.all").handler(this.users)
        vertx.eventBus.consumer("users.one").handler(this.user)
    }

    private def users(message: Message[AnyRef]): Unit = {
        val json = userRepository.readUsers
            .map { user => toJson(user) }
            .foldLeft(new JsonArray) { (arr, user) => arr.add(user) }

        message.reply(json)
    }

    private def user(message: Message[AnyRef]): Unit = {
        userRepository.readUser(message.body.toString) match {
            case Some(user) => message.reply(toJson(user))
            case None => message.fail(404, "No such user")
        }
    }

    private def toJson(user: User): JsonObject = {
        new JsonObject()
            .put("username", user.username)
            .put("name", user.name)
    }

}
