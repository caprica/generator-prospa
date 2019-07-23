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
    private val userService: UserService = null

    @RequestMapping(value = Array("/api/users"), method = Array(RequestMethod.GET))
    def users: List[User] = {
        // Add a fake delay so we can see state changes in the UI
        Thread.sleep(1000)

        userService.users
    }

    @RequestMapping(value = Array("/api/users/{username}"), method = Array(RequestMethod.GET))
    def user(@PathVariable("username") username: String): ResponseEntity[User] = {
        // Add a fake delay so we can see state changes in the UI
        Thread.sleep(1000)

        userService.user(username) match {
            case Some(user) => new ResponseEntity[User](user, HttpStatus.OK)
            case None => new ResponseEntity[User](HttpStatus.NOT_FOUND)
        }
    }

}
