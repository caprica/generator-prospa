package <%= packageName %>.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import <%= packageName %>.domain.User
import <%= packageName %>.service.UserService

/**
 * An example web service API controller.
 */
@RestController
class UserController {

    @Autowired
    private val userService: UserService? = null

    @RequestMapping(value = ["/api/users"], method = [RequestMethod.GET])
    fun users(): Collection<User> {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        return userService!!.users()
    }

    @RequestMapping(value = ["/api/users/{username}"], method = [RequestMethod.GET])
    fun user(@PathVariable("username") username: String): ResponseEntity<User> {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        val user: User? = userService!!.user(username)
        return if (user != null) ResponseEntity(user, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

}
